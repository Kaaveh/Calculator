package ir.kaaveh.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var firstNumber = 0.0
    var secondNumber = 0.0
    var result = MutableLiveData(0.0)

    fun calculate(operator: String) {
        result.value = when(operator) {
            "+" -> {firstNumber + secondNumber}
            "-" -> {firstNumber - secondNumber}
            "*" -> {firstNumber * secondNumber}
            else -> {firstNumber / secondNumber}
        }
    }
}