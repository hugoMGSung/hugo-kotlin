package com.hugo83.recyclerviewtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.hugo83.recyclerviewtest.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        bind = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(bind.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        // 랜덤 데이터 생성
        val itemList = List(100) { i ->
            ItemData(
                number = i + 1, // 순번
                title = "안드로이드 코틀린 개발 ${Random.nextInt(1, 1000)}", // 랜덤 제목
                date = generateRandomDate() // 랜덤날짜 생성함수
            )
        }

        // RecyclerView 설정
        bind.recyclerView.layoutManager = LinearLayoutManager(this)
        bind.recyclerView.adapter = ItemAdapter(itemList)
    }

    // 랜덤날짜 생성함수
    private fun generateRandomDate(): String {
        val date = Date(System.currentTimeMillis() - Random.nextLong(0, 365L * 24 * 60 * 60 * 1000))
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }
}