package com.homework.gblesson1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.homework.gblesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val CALK_CLASS = "keyForBundle"
    lateinit var binding: ActivityMainBinding
    private lateinit var calculator: Calculator
    private var themeId = -1

    companion object {
        var THEME_APP = "themeKey"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            if (savedInstanceState.getInt(THEME_APP, -1) != -1) {
                setTheme(savedInstanceState.getInt(THEME_APP))
            }
        }
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initMain()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            themeId = data.getIntExtra(THEME_APP, -1)
        }
        recreate()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(CALK_CLASS, calculator)
        outState.putInt(THEME_APP, themeId)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        calculator = savedInstanceState.getParcelable(CALK_CLASS)!!
        binding.actionLineText.setText(calculator.actionLine)
    }

    private fun clickOnNumber(button: Button) {
        calculator.addNumber(button.text.toString())
        binding.actionLineText.setText(calculator.actionLine)
    }

    private fun clickOnOperation(key: String, button: Button) {
        calculator.addCalcAction(button.text[0])
//        calculator.addChar(button.text.toString())
        binding.actionLineText.setText(calculator.actionLine)
    }

    private fun clickOnComma() {
        calculator.addComm()
//        calculator.addChar(".")
        binding.actionLineText.setText(calculator.actionLine)
    }

    private fun initMain() {

        calculator = Calculator()

        val numberButton = arrayOfNulls<Button>(10)
        numberButton[0] = binding.button0
        numberButton[1] = binding.button1
        numberButton[2] = binding.button2
        numberButton[3] = binding.button3
        numberButton[4] = binding.button4
        numberButton[5] = binding.button5
        numberButton[6] = binding.button6
        numberButton[7] = binding.button7
        numberButton[8] = binding.button8
        numberButton[9] = binding.button9

        val operationsButton: Map<String, Button> = mapOf(
            "Division" to binding.buttonDivision,
            "Multi" to binding.buttonMulti,
            "Sub" to binding.buttonSub,
            "Add" to binding.buttonAdd,
            "Res" to binding.buttonRes
        )

        binding.buttonComma.setOnClickListener { clickOnComma() }

        numberButton.forEach {
            it!!.setOnClickListener { clickOnNumber(it as Button) }
        }

        operationsButton.forEach { (key, value) ->
            value.setOnClickListener { clickOnOperation(key, value) }
        }

        binding.buttonChangeTheme.setOnClickListener {
            val intent = Intent(this, ChangeThemeActivity::class.java)
            startActivityForResult(intent,1)
        }
    }
}