package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    companion object {
        val TAG = "TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initObserves()
    }

    private fun updateText(text: String) {
        binding.editTextTextPersonName.setText("${binding.editTextTextPersonName.text}$text")
    }

    private fun initObserves() {
        viewModel.userString.observe(this@MainActivity) {
            updateText(it)
            Log.d(TAG, "${viewModel.userString}")
        }
    }

    private fun initView() {
        binding.btnNumberTwo.setOnClickListener {
            viewModel.updateText("2")

        }
        binding.textView.addTextChangedListener {
            viewModel.updateText(it.toString())
        }
    }
}