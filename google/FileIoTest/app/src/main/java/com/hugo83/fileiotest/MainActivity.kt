package com.hugo83.fileiotest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.fileiotest.databinding.ActivityMainBinding
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fileName = "hugoTest.txt"  // 저장할 파일 이름

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

        // 저장 버튼 클릭 시 파일에 쓰기
        binding.buttonSave.setOnClickListener {
            val textToSave = binding.editText.text.toString()
            if (textToSave.isNotEmpty()) {
                saveToFile(textToSave)
            } else {
                Toast.makeText(this, "텍스트를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 로드 버튼 클릭 시 파일에서 읽기
        binding.buttonLoad.setOnClickListener {
            loadFromFile()
        }
    }

    // 파일에 텍스트 저장
    private fun saveToFile(text: String) {
        try {
            val fileOutputStream: FileOutputStream = openFileOutput(fileName, MODE_PRIVATE)
            fileOutputStream.write(text.toByteArray())
            fileOutputStream.close()
            Toast.makeText(this, "파일에 저장되었습니다.", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "파일 저장에 실패했습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    // 파일에서 텍스트 읽기
    private fun loadFromFile() {
        try {
            val fileInputStream: FileInputStream = openFileInput(fileName)
            val inputStreamReader = fileInputStream.bufferedReader()
            val content = inputStreamReader.use { it.readText() }
            fileInputStream.close()
            binding.textView.text = content
            Toast.makeText(this, "파일에서 로드되었습니다.", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "파일 읽기에 실패했습니다.", Toast.LENGTH_SHORT).show()
        }
    }
}