package com.hugo83.imagedownloader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        binding.run { // run으로 감싸고
            binding.buttonDownload.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch { // 코루틴스코프를 launch로 실행하며
                    binding.progress.visibility = View.VISIBLE

                    val url = binding.editUrl.text.toString()
                    val bitmap = withContext(Dispatchers.IO) { // 디스패처 IO가 완료되면
                        loadImage(url) // 서스펜드 함수를 호출한다.
                    }
                    binding.imagePreview.setImageBitmap(bitmap)
                    binding.progress.visibility = View.GONE
                 }
            }
        }
    } // 그외 나머지는 기존 소스들과 동일함
}

// suspend 키워드는 해당 함수가 일시 중단(suspend) 될 수 있으며, 코루틴 내에서 호출될 수 있음
suspend fun loadImage(imageUrl:String) : Bitmap {
    val url = URL(imageUrl)
    val stream = url.openStream()
    return BitmapFactory.decodeStream(stream)
}