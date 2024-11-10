package com.hugo83.camerareg3

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.hugo83.camerareg3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var photoURI: Uri? = null

    private val requestCameraPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            openCamera()
        } else {
            Toast.makeText(this, "카메라 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private val capturePhoto = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            photoURI?.let { binding.imageView.setImageURI(it) }
        } else {
            Toast.makeText(this, "사진 촬영 실패", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                requestCameraPermission.launch(Manifest.permission.CAMERA)
            }
        }

        binding.buttonLoadImage.setOnClickListener {
            loadImageFromGallery()
        }
    }

    private fun openCamera() {
        photoURI = createImageUri()
        photoURI?.let { capturePhoto.launch(it) }  // 아 이거네!!
    }

    private fun createImageUri(): Uri? {
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "new_photo.jpg")
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
    }

    // 갤러리에서 사진 불러오기
    private fun loadImageFromGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, REQUEST_IMAGE_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_IMAGE_CAPTURE -> {
                    photoURI?.let {
                        binding.imageView.setImageURI(it)  // 촬영한 사진을 ImageView에 표시
                        Toast.makeText(this, "사진이 저장되었습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                REQUEST_IMAGE_PICK -> {
                    photoURI = data?.data
                    binding.imageView.setImageURI(photoURI)  // 불러온 사진을 ImageView에 표시
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                openCamera()
            } else {
                Toast.makeText(this, "권한이 필요합니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1
        private const val REQUEST_IMAGE_PICK = 2
        private const val REQUEST_PERMISSIONS = 100
    }
}