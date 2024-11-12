package com.hugo83.imagedownloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.hugo83.imagedownloader.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDownload.setOnClickListener {
            val url = binding.editUrl.text.toString()
            if (url.isNotBlank()) {
                downloadImage(url)
            } else {
                Toast.makeText(this, "URL을 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun downloadImage(url: String) {
        lifecycleScope.launch {
            // 프로그래스바 표시
            binding.progress.visibility = android.view.View.VISIBLE
            try {
                withContext(Dispatchers.IO) {
                    Glide.with(this@MainActivity)
                        .load(url)
                        .submit()
                        .get()
                }

                // UI 스레드에서 이미지 표시
                Glide.with(this@MainActivity)
                    .load(url)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.imagePreview)

            } catch (e: Exception) {
                // 예외 발생 시 기본 이미지 표시 및 오류 메시지
                Glide.with(this@MainActivity)
                    .load(R.drawable.ic_launcher_foreground)
                    .into(binding.imagePreview)

                Toast.makeText(this@MainActivity, "이미지 다운로드 실패", Toast.LENGTH_SHORT).show()
            } finally {
                // 프로그래스바 숨기기
                binding.progress.visibility = android.view.View.GONE
            }
        }
    }
}
