package com.example.tutorialapp

import android.os.Bundle  // 안드로이드에서 데이터를 임시로 저장하고 전달하는 데 사용하는 객체
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorialapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mine = ActivityMainBinding.inflate(layoutInflater)
        /* 안드로이드 앱에서 Edge-to-Edge 디자인을 적용하기 위해 사용하는 함수
            앱의 UI를 화면 가장자리까지 확장하여 시스템 내비게이션 바나 상태 표시줄과 겹치는 부분까지 콘텐츠가 표시되도록 하는 것
            안드로이드 10(API 29)부터 도입
         */
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main) // res/layout/activity_main.xml을 사용한다
        setContentView(mine.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        // 굳이 위의 소스 부분이 문제를 일으키진 않는다. 현재까진...

        mine.button.setOnClickListener {
            mine.textView.text = "Hello, Kotlin!!!!"
        }
    }
}