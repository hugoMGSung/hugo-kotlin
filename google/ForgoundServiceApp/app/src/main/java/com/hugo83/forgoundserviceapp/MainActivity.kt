package com.hugo83.forgoundserviceapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.forgoundserviceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 서비스 시작
        binding.startServiceButton.setOnClickListener {
            val serviceIntent = Intent(this, MyForegroundService::class.java)
            startService(serviceIntent)
        }

        // 서비스 중지
        binding.stopServiceButton.setOnClickListener {
            val serviceIntent = Intent(this, MyForegroundService::class.java)
            stopService(serviceIntent)
        }
    }
}