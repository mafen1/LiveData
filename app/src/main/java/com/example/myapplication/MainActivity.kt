package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: ViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    companion object {
        val TAG = "TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserves()
        binding.btnNumberFive.setOnClickListener(this)
        binding.btnNumberTwo.setOnClickListener(this)
        binding.btnPlus.setOnClickListener(this)
        binding.btnEquals.setOnClickListener(this)
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
    override fun onClick(view: View?) {
        // стало
        when (view!!.id) {
            R.id.btnNumberTwo -> viewModel.updateText("2")
            R.id.btnNumberFive ->  viewModel.updateText("5")
            R.id.btnPlus -> viewModel.updateText("+")
            R.id.btnEquals -> binding.editTextTextPersonName.setText("${viewModel.pop().toString()}")
        }
    }

}