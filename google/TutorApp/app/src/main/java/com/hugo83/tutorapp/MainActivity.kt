package com.hugo83.tutorapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.tutorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // ToggleButton 상태 리스너 설정
        binding.toggleButton.setOnCheckedChangeListener { _, isChecked ->
            updateStatus()
        }

        // Switch 상태 리스너 설정
        binding.switchButton.setOnCheckedChangeListener { _, isChecked ->
            updateStatus()
        }

        // 초기 상태 업데이트
        updateStatus()
    }

    // ToggleButton 및 Switch 상태에 따라 이미지와 텍스트를 업데이트하는 함수
    private fun updateStatus() {
        val toggleState = if (binding.toggleButton.isChecked) "ON" else "OFF"
        val switchState = if (binding.switchButton.isChecked) "ON" else "OFF"

        // 상태 텍스트 업데이트
        binding.statusTextView.text = "Toggle: $toggleState, Switch: $switchState"

        // 이미지 변경 (두 버튼이 모두 ON일 때만 이미지 변경)
        if (binding.toggleButton.isChecked && binding.switchButton.isChecked) {
            binding.imageView.setImageResource(R.drawable.ic_launcher_foreground) // 이미지 예시
        } else {
            binding.imageView.setImageResource(R.drawable.ic_launcher_background) // 다른 이미지 예시
        }
    }
}