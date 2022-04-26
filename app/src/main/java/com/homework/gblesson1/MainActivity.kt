package com.homework.gblesson1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homework.gblesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView2.text = "работает"

        binding.buttonNextLayout.setOnClickListener {
            val intent = Intent(this, NoMainActivity::class.java)
            startActivity(intent)
        }


    }
}