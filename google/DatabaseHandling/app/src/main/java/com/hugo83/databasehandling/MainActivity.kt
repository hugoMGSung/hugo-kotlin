package com.hugo83.databasehandling

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.databasehandling.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelper

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

        // DatabaseHelper 인스턴스 생성
        dbHelper = DatabaseHelper(this)

        // 데이터 삽입 버튼 클릭 리스너
        binding.buttonInsert.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString().toIntOrNull()

            if (name.isNotEmpty() && age != null) {
                val result = dbHelper.insertData(name, age)
                if (result != -1L) {
                    Toast.makeText(this, "데이터가 저장되었습니다.", Toast.LENGTH_SHORT).show()
                    binding.editTextName.text.clear()
                    binding.editTextAge.text.clear()
                } else {
                    Toast.makeText(this, "저장에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "이름과 나이를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        // 데이터 조회 버튼 클릭 리스너
        binding.buttonSelect.setOnClickListener {
            displayData()
        }
    }

    // 조회한 데이터 표시 메서드
    private fun displayData() {
        val cursor = dbHelper.getAllData()
        val stringBuilder = StringBuilder()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME))
                val age = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_AGE))

                stringBuilder.append("ID: $id\nName: $name\nAge: $age\n\n")
            } while (cursor.moveToNext())
        } else {
            stringBuilder.append("No data found")
        }

        binding.textViewResult.text = stringBuilder.toString()
        cursor.close()
    }
}