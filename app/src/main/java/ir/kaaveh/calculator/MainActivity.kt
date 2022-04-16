package ir.kaaveh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var firstNumber = 0.0
    private var secondNumber = 0.0

    private lateinit var firstNumberText: EditText
    private lateinit var secondNumberText: EditText

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
            resultText.text = (firstNumber + secondNumber).toString()
        }
        minusButton.setOnClickListener {
            getEditText()
            resultText.text = (firstNumber - secondNumber).toString()
        }
        multiButton.setOnClickListener {
            getEditText()
            resultText.text = (firstNumber * secondNumber).toString()
        }
        divideButton.setOnClickListener {
            getEditText()
            resultText.text = (firstNumber / secondNumber).toString()
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
            firstNumber = firstNumberText.text.toString().toDouble()

        if (secondNumberText.text.toString().isNotEmpty())
            secondNumber = secondNumberText.text.toString().toDouble()
    }
}