package com.example.myapplication

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity.Companion.TAG
import com.google.android.material.snackbar.Snackbar

class ViewModel : ViewModel() {
    lateinit var view: View
    var finalResult = 0
    var counter = 0

    private val _userInputFirstNumber: MutableLiveData<String> = MutableLiveData("")
    val userInputFirstNumber: LiveData<String> = _userInputFirstNumber

    private val _operations: MutableLiveData<String> = MutableLiveData("")


    private var _result: MutableLiveData<String> = MutableLiveData("")


    fun updateText(string: String) {
        if (counter <= 9) {
            _userInputFirstNumber.value = string
            counter++
        }else{
            makeSnackbar("Больше 9 цифр нельзя вводить")
        }
    }

    private fun choseOperations(operation: String): String {
        _operations.value = operation
        return _operations.value.toString()
    }

    fun operations(result: String) {
        _result.value = result
        val getString = _result.value!!.split(_operations.value.toString())
        when (_operations.value) {
            "+" -> finalResult = getString[0].toInt() + getString[1].toInt()
            "-" -> finalResult = getString[0].toInt() - getString[1].toInt()
        }
    }

    fun printOperation(operation: String) {
        if (_operations.value == "") {
            if (userInputFirstNumber.value != "") {
                choseOperations(operation)
                updateText(operation)
            } else {
             makeSnackbar("Введите хотя бы одно число")
            }
        } else {
           makeSnackbar("Нельзя вводить больше одного оператора")
        }
    }

    fun makeSnackbar(string: String){
        Snackbar.make(
            view,
            string,
            Snackbar.LENGTH_LONG
        ).show()
    }
}


