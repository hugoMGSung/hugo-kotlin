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

        // RadioGroup에 리스너 추가
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // 선택된 RadioButton 가져오기
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            // TextView에 선택된 옵션 표시
            binding.selectedOptionTextView.text = "선택된 옵션: ${selectedRadioButton.text}"
        }
    }
}