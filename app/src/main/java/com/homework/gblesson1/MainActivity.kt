package com.homework.gblesson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.homework.gblesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //window.setBackgroundDrawableResource(R.drawable.back_for_calculater)


    }
}