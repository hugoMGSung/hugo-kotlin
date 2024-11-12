package com.hugo83.threadtest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.threadtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val handler = Handler(Looper.getMainLooper())
    private var milliseconds = 0  // 밀리초 단위 시간 저장
    private var isRunning = false  // 타이머 동작 여부

    private val runnable = object : Runnable {
        override fun run() {
            if (isRunning) {
                milliseconds += 10  // 10ms마다 증가
                updateTimerText()
                handler.postDelayed(this, 10)  // 10ms 지연 후 다시 실행
            }
        }
    }

    private fun updateTimerText() {
        val minutes = milliseconds / 60000
        val seconds = (milliseconds % 60000) / 1000
        val millis = milliseconds % 1000 / 10
        val time = String.format("%02d:%02d:%02d", minutes, seconds, millis)
        binding.timerTextView.text = time  // 타이머 텍스트 업데이트
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 시작 버튼 클릭 리스너
        binding.startButton.setOnClickListener {
            if (!isRunning) {
                isRunning = true
                handler.post(runnable)  // Runnable 시작
            }
        }

        // 중지 버튼 클릭 리스너
        binding.stopButton.setOnClickListener {
            isRunning = false  // 타이머 일시 중지
        }

        // 초기화 버튼
        binding.resetButton.setOnClickListener {
            isRunning = false
            milliseconds = 0
            updateTimerText()
        }
    }
}