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

        // 체크박스들을 클릭할 때마다 선택된 항목을 업데이트
        val checkBoxes = listOf(
            binding.checkBoxOption1,
            binding.checkBoxOption2,
            binding.checkBoxOption3,
            binding.checkBoxOption4
        )

        checkBoxes.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { _, _ ->
                updateSelectedOptions()
            }
        }
    }

    // 선택된 체크박스를 텍스트 뷰에 표시하는 함수
    private fun updateSelectedOptions() {
        val selectedOptions = mutableListOf<String>()

        if (binding.checkBoxOption1.isChecked) selectedOptions.add(binding.checkBoxOption1.text.toString())
        if (binding.checkBoxOption2.isChecked) selectedOptions.add(binding.checkBoxOption2.text.toString())
        if (binding.checkBoxOption3.isChecked) selectedOptions.add(binding.checkBoxOption3.text.toString())
        if (binding.checkBoxOption4.isChecked) selectedOptions.add(binding.checkBoxOption4.text.toString())

        binding.selectedOptionsTextView.text = "선택된 체크박스값: ${selectedOptions.joinToString(", ")}"
    }
}