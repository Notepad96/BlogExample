package com.example.activityresultapi

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.activityresultapi.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val getContentImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri.let { binding.mainImg.setImageURI(uri) }
    }
    var pictureUri: Uri? = null
    private val getTakePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        if(it) {
            pictureUri.let { binding.mainImg.setImageURI(pictureUri) }
        }
    }
    private val getTakePicturePreview = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        bitmap.let { binding.mainImg.setImageBitmap(bitmap) }
    }

    private val requestMultiplePermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
        results.forEach {
            if(!it.value) {
                Toast.makeText(applicationContext, "권한 허용 필요", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestMultiplePermission.launch(permissionList)

        binding.mainBtn.setOnClickListener {
            openDialog(this)
        }
    }
    private val permissionList = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE)

    private fun openDialog(context: Context) {
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_select_image, null)
        val dialogBuild = AlertDialog.Builder(context).apply {
            setView(dialogLayout)
        }
        val dialog = dialogBuild.create().apply { show() }

        val cameraAddBtn = dialogLayout.findViewById<Button>(R.id.dialog_btn_camera)
        val fileAddBtn = dialogLayout.findViewById<Button>(R.id.dialog_btn_file)

        cameraAddBtn.setOnClickListener {
            pictureUri = createImageFile()
//            getTakePicture.launch(pictureUri)   // Require Uri
            getTakePicturePreview.launch(null)    // Bitmap get
            dialog.dismiss()
        }
        fileAddBtn.setOnClickListener {
            getContentImage.launch("image/*")
            dialog.dismiss()
        }
    }

    private fun createImageFile(): Uri? {
        val now = SimpleDateFormat("yyMMdd_HHmmss").format(Date())
        val content = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "img_$now.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpg")
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, content)
    }

}

