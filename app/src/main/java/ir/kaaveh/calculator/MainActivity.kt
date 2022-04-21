package ir.kaaveh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private lateinit var firstNumberText: EditText
    private lateinit var secondNumberText: EditText

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberText = findViewById(R.id.editTextNumberOne)
        secondNumberText = findViewById(R.id.editTextNumberTwo)

        val resultText = findViewById<TextView>(R.id.textResult)

        val addButton = findViewById<Button>(R.id.buttonAdd)
        val minusButton = findViewById<Button>(R.id.buttonMinus)
        val multiButton = findViewById<Button>(R.id.buttonMulti)
        val divideButton = findViewById<Button>(R.id.buttonDivide)

        val buttonOne = findViewById<Button>(R.id.buttonOne)

        viewModel.result.observe(this){
            resultText.text = it.toString()
        }

        addButton.setOnClickListener {
            getEditText()
            viewModel.calculate("+")
        }
        minusButton.setOnClickListener {
            getEditText()
            viewModel.calculate("-")
        }
        multiButton.setOnClickListener {
            getEditText()
            viewModel.calculate("*")
        }
        divideButton.setOnClickListener {
            getEditText()
            viewModel.calculate("/")
        }

        buttonOne.setOnClickListener {
            if (firstNumberText.hasFocus()){
                firstNumberText.append("1")
            }
            if (secondNumberText.hasFocus()){
                secondNumberText.append("1")
            }
        }
    }

    private fun getEditText() {
        if (firstNumberText.text.toString().isNotEmpty())
            viewModel.firstNumber = firstNumberText.text.toString().toDouble()

        if (secondNumberText.text.toString().isNotEmpty())
            viewModel.secondNumber = secondNumberText.text.toString().toDouble()
    }
}