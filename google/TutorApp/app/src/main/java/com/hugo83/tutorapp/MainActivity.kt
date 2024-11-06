package com.hugo83.tutorapp

import android.app.Activity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.RatingBar
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

        // RatingBar 값 변경 리스너 설정
        binding.ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener { _, rating, _ ->
                binding.ratingTextView.text = "Rating: $rating"
            }
    }
}