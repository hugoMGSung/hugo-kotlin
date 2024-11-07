package com.hugo83.camerareg

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.camerareg.databinding.ActivityMainBinding

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 버튼 클릭 시 카메라 권한 요청
        binding.buttonCamera.setOnClickListener {
            checkCameraPermission()
        }
    }

    // 카메라 권한을 확인하고 요청하는 메서드
    private fun checkCameraPermission() {
        when {
            // 이미 권한이 부여된 경우
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                openCamera()
            }
            // 권한이 거부된 경우, 권한 요청
            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) -> {
                Toast.makeText(this, "카메라 권한이 필요합니다.", Toast.LENGTH_SHORT).show()
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
            // 처음 권한을 요청하는 경우
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    // 권한 요청 결과 처리
    private val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            openCamera()
        } else {
            Toast.makeText(this, "카메라 권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    // 카메라를 여는 메서드 (임시로 Toast 메시지로 카메라가 열렸다고 표시)
    private fun openCamera() {
        Toast.makeText(this, "카메라를 열었습니다.", Toast.LENGTH_SHORT).show()
        // 실제 카메라 기능 구현 부분 (카메라 앱을 호출하거나 카메라 화면 구현)
    }
}