package com.hugo83.foregroundservice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.foregroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            val intent = Intent(this, Foreground::class.java)
            ContextCompat.startForegroundService(this, intent)
        }

        binding.buttonStop.setOnClickListener {
            val intent = Intent(this, Foreground::class.java)
            stopService(intent)
        }
    }
}