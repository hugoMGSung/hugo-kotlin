package com.hugo83.videoplayer

import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.videoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var playing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {
            buttonPlay.setOnClickListener {
                val videoUri = Uri.parse("https://download.blender.org/peach/bigbuckbunny_movies/BigBuckBunny_640x360.m4v")
                videoView.setVideoURI(videoUri)
            }

            videoView.setOnPreparedListener { mediaPlayer ->
                playing = true
                videoView.start()
            }

            pausePlay.setOnClickListener {
                if (playing == true) {
                    playing = false
                    onPause()
                    pausePlay.text = "Resume"
                }
                else {
                    playing = true
                    onResume()
                    pausePlay.text = "Pause"
                }

            }
        }
    }

    override fun onPause() {
        if(playing) {
            binding.textView.text = "동영상 멈춤."
            binding.videoView.pause()
        }
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        if(playing) {
            binding.videoView.resume()
            binding.textView.text = "동영상이 실행중입니다."
        }
    }
}