package com.hugo83.firebaseapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.hugo83.firebaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater)  }
    private val database = FirebaseDatabase.getInstance().getReference("items")
    private val itemList = mutableListOf<String>()
    private val adapter = ItemAdapter(itemList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            val data = binding.inputData.text.toString()
            if (data.isNotEmpty()) {
                database.push().setValue(data).addOnCompleteListener {
                    if (it.isSuccessful) {
                        binding.inputData.text.clear()
                        Toast.makeText(this, "Data added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Failed to add data.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // Realtime Database 변경사항 읽기
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                itemList.clear()
                for (itemSnapshot in snapshot.children) {
                    val item = itemSnapshot.getValue(String::class.java)
                    item?.let { itemList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to load data.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}