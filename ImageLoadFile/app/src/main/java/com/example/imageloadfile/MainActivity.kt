package com.example.imageloadfile

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import coil.load
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_PERMISSIONS = 1
    private val REQUEST_IMAGE = 111
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()


        btn_file_img.setOnClickListener {
            val intent = Intent().apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
            }
            startActivityForResult(intent, REQUEST_IMAGE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_IMAGE) {
            if(resultCode == RESULT_OK) {
                img_load.load(data?.data) {
                    crossfade(1500)
                }
            }
        }
    }

    private fun checkPermission() {
        var permission = mutableMapOf<String, String>()
        permission["storageRead"] = Manifest.permission.READ_EXTERNAL_STORAGE

        // 현재 권한 상태 검사
        var denied = permission.count { ContextCompat.checkSelfPermission(this, it.value)  == PackageManager.PERMISSION_DENIED }

        // 마시멜로 버전 이후
        if(denied > 0 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permission.values.toTypedArray(), REQUEST_PERMISSIONS)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_PERMISSIONS) {


            /* 2. 권한 요청을 거부했다면 안내 메시지 보여주며 앱 종료 */
            grantResults.forEach {
                if(it == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(applicationContext, "서비스의 필요한 권한입니다.\n권한에 동의해주세요.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}