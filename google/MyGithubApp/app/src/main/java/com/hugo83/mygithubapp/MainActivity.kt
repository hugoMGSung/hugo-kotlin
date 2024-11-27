package com.hugo83.mygithubapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.hugo83.mygithubapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnFetch.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            if (username.isNotEmpty()) {
                fetchGitHubUser(username)
            } else {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchGitHubUser(username: String) {
        lifecycleScope.launch {
            try {
                val user = RetrofitInstance.api.getUser(username)
                displayUserInfo(user)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun displayUserInfo(user: GitHubUser) {
        binding.tvName.text = user.name ?: "No Name Available"
        binding.tvUsername.text = user.login
        binding.tvRepos.text = "Public Repos: ${user.public_repos}"
        binding.tvFollowers.text = "Followers: ${user.followers}"
        binding.tvFollowing.text = "Following: ${user.following}"

        Glide.with(this).load(user.avatar_url).into(binding.ivAvatar)
    }
}