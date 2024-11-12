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
    private var updateCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Runnable 객체 생성
        val runnable = object: Runnable {
            override fun run() {
                if (updateCount < 100) {
                    updateCount++
                    binding.textView.text = "업데이트 $updateCount"
                    Log.d("Debug", "업데이트 $updateCount")
                    handler.postDelayed(this, 200) // 1초 지연
                } else {
                    binding.textView.text = "업데이트 완료!"
                }
            }
        }

        // 첫 실행
        handler.post(runnable)
    }
}