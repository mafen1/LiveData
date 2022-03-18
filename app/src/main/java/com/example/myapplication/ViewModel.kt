package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity.Companion.TAG

class ViewModel: ViewModel() {

    private val _userString: MutableLiveData<String> = MutableLiveData("")
    val userString: LiveData<String> = _userString



    fun updateText(string: String){
        _userString.postValue(string)
        Log.d(TAG, "$_userString 12")
    }
    fun pop(){
        val ii = _userString.value
        Log.d(TAG, "$ii")
    }

}