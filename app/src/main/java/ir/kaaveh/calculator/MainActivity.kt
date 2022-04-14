package ir.kaaveh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumberText = findViewById<EditText>(R.id.editTextNumberOne)
        val secondNumberText = findViewById<EditText>(R.id.editTextNumberTwo)

        val resultText = findViewById<TextView>(R.id.textResult)

        val addButton = findViewById<Button>(R.id.buttonAdd)

        addButton.setOnClickListener {
            val firstNumber = firstNumberText.text.toString().toDouble()
            val secondNumber = secondNumberText.text.toString().toDouble()

            resultText.text = (firstNumber + secondNumber).toString()
        }
    }
}