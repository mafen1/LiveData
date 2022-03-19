package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity.Companion.TAG

class ViewModel : ViewModel() {
     var finalResult:Int = 0
    private val _userInputFirstNumber: MutableLiveData<String> = MutableLiveData("")
    val userInputFirstNumber: LiveData<String> = _userInputFirstNumber

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

    fun update(result: String): String {
        _result.value = result
        val getString = _result.value!!.split("+")
        finalResult = getString[0].toInt() + getString[1].toInt()
        return finalResult.toString()
    }

}