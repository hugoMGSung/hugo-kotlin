package com.hugo83.tutorapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.tutorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mine = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        setContentView(mine.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mine.button.setOnClickListener {
            mine.textView.text = "Hi, Kotlin"
            Log.d("동작", "버튼 클릭했습니다.")
        }
    }
}