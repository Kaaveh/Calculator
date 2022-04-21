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

        addButton.setOnClickListener {
            getEditText()
            resultText.text = (viewModel.firstNumber + viewModel.secondNumber).toString()
        }
        minusButton.setOnClickListener {
            getEditText()
            resultText.text = (viewModel.firstNumber - viewModel.secondNumber).toString()
        }
        multiButton.setOnClickListener {
            getEditText()
            resultText.text = (viewModel.firstNumber * viewModel.secondNumber).toString()
        }
        divideButton.setOnClickListener {
            getEditText()
            resultText.text = (viewModel.firstNumber / viewModel.secondNumber).toString()
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