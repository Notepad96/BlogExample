package com.example.permissionsexample02

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 권한 요청
    private val requestMultiplePermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
        results.forEach {
            if(!it.value) {
                Toast.makeText(applicationContext, "${it.key} 권한 허용 필요", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    // 추가할 권한들, 매니페스트 파일서도 추가 필요
    private val permissionList = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestMultiplePermission.launch(permissionList)
    }
}