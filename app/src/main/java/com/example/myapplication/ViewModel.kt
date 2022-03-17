package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MainActivity.Companion.TAG

class ViewModel: ViewModel() {
    private val _userString: MutableLiveData<String> = MutableLiveData("")
    val userString = _userString

    fun updateText(string: String){
        _userString.postValue(string)
        Log.d(TAG, "$_userString 12")
    }
}