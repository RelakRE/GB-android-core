package com.homework.gblesson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.homework.gblesson1.databinding.ActivityNoMainBinding

class NoMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityNoMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}
