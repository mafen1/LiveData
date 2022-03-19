package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity.Companion.TAG

class ViewModel : ViewModel() {
    var finalResult: Int = 0
    var operationInViewModel = ""

    private val _userInputFirstNumber: MutableLiveData<String> = MutableLiveData("")
    val userInputFirstNumber: LiveData<String> = _userInputFirstNumber

    private val _oprerations: MutableLiveData<String> = MutableLiveData("")
    val operations: LiveData<String> = _oprerations

    private var _result: MutableLiveData<String> = MutableLiveData("")
    val result: LiveData<String> = _result


    fun updateText(string: String) {
        _userInputFirstNumber.postValue(string)
//        Log.d(TAG, "${_userString.value}")
    }

    fun pop() {
        val ii = userInputFirstNumber.value.toString()
        Log.d(TAG, ii)
    }

    fun plus(result: String): String {
        _result.value = result
        val getString = _result.value!!.split("+")
        finalResult = getString[0].toInt() + getString[1].toInt()
        return finalResult.toString()
    }

    fun choseOperations(operation: String): String{
        _oprerations.value = operation
        operationInViewModel = operation
        return _oprerations.value.toString()
    }
    fun operations(result: String) {
        _result.value = result
        val getString = _result.value!!.split(operationInViewModel)
        when(_oprerations.value){
            "+" -> finalResult = getString[0].toInt() + getString[1].toInt()

            "-" -> finalResult = getString[0].toInt() - getString[1].toInt()
        }
    }


}