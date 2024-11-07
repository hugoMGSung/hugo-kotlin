package com.hugo83.multifragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hugo83.multifragment.databinding.ActivityMainBinding
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 처음에 FragmentOne을 표시
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FragmentOne())
            .commit()

        // 각 버튼을 클릭하면 해당 Fragment로 전환
        binding.buttonFragment1.setOnClickListener {
            replaceFragment(FragmentOne())
        }

        binding.buttonFragment2.setOnClickListener {
            replaceFragment(FragmentTwo())
        }

        binding.buttonFragment3.setOnClickListener {
            replaceFragment(FragmentThree())
        }
    }

    // Fragment를 교체하는 메서드
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}