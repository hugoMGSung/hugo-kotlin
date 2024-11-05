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
    private var progressStatus = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // Increase 버튼 클릭 리스너
        binding.increaseButton.setOnClickListener {
            increaseProgress()
        }
    }

    // ProgressBar와 TextView의 진행 상태를 업데이트하는 함수
    private fun increaseProgress() {
        // 100% 미만일 때만 증가
        if (progressStatus < 100) {
            progressStatus += 10 // 증가할 값 설정
            binding.progressBar.progress = progressStatus
            binding.progressTextView.text = "Progress: $progressStatus%"
        }
    }
}