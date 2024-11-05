package com.hugo83.tutorapp

import android.app.Activity
import android.os.Bundle
import android.widget.SeekBar
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

        // SeekBar 변경 리스너 설정
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // SeekBar 값이 변경될 때 호출
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.seekBarValueTextView.text = "SeekBar Value: $progress"
            }

            // SeekBar 사용자가 터치할 때 호출
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // 필요 시 추가 동작 작성 가능
            }

            // SeekBar 사용자가 터치를 끝낼 때 호출
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // 필요 시 추가 동작 작성 가능
            }
        })
    }
}