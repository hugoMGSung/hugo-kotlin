package com.hugo83.sharedprefertest

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.sharedprefertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sharedPrefFile = "mySharedPref"  // SharedPreferences 파일 이름

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 저장 버튼 클릭 시 SharedPreferences에 데이터 저장
        binding.buttonSave.setOnClickListener {
            val textToSave = binding.editText.text.toString()
            if (textToSave.isNotEmpty()) {
                val editor = sharedPreferences.edit()
                editor.putString("savedText", textToSave)
                editor.apply()
                Toast.makeText(this, "데이터가 저장되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "저장할 텍스트를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 로드 버튼 클릭 시 SharedPreferences에서 데이터 불러오기
        binding.buttonLoad.setOnClickListener {
            val savedText = sharedPreferences.getString("savedText", "저장된 데이터가 없습니다.")
            binding.textView.text = savedText
            Toast.makeText(this, "데이터가 불러와졌습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}