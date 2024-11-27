package com.hugo83.firebaseapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.database
import com.hugo83.firebaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apps = FirebaseApp.getApps(this)
        if (apps.isEmpty()) {
            Log.e("HUGO!!!", "Firebase 초기화 실패!")
        } else {
            Log.d("HUGO!!!", "Firebase 초기화 성공!")
        }

        val database = Firebase.database
        val myRef = database.getReference("message")
        myRef.setValue("Hello, Firebase!!")
        binding.result.setText("Firebase로 가보셈!!")
    }
}