package com.homework.gblesson1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.homework.gblesson1.databinding.ActivityChangeThemeBinding


class ChangeThemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangeThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MaterialComponents_NoActionBar)
        super.onCreate(savedInstanceState)
        binding = ActivityChangeThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.materialLight.setOnClickListener {
            returnTheme(R.style.Theme_MaterialComponents_Light)
        }
        binding.materialDayNight.setOnClickListener {
            returnTheme(R.style.Theme_MaterialComponents_DayNight)
        }
        binding.materialNoActionbar.setOnClickListener {
            returnTheme(R.style.Theme_MaterialComponents_NoActionBar)
        }
        binding.appcompatDayNight.setOnClickListener {
            returnTheme(R.style.Theme_AppCompat_DayNight)
        }
    }

    fun returnTheme(themeId: Int){
        val intent = Intent()
        intent.putExtra(MainActivity.THEME_APP, themeId)
        setResult(RESULT_OK, intent)
        finish()
    }

}