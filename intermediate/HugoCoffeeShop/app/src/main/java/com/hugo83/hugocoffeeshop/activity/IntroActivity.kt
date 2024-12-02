package com.hugo83.hugocoffeeshop.activity

import android.content.Intent
import android.os.Bundle
import com.hugo83.hugocoffeeshop.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    val binding by lazy { ActivityIntroBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }
    }
}