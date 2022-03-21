package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val TAG = "TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.view = binding.root
        initObserves()
        initButton()

    }

    @SuppressLint("SetTextI18n")
    private fun updateText(text: String) {
        binding.editTextTextPersonName.setText("${binding.editTextTextPersonName.text}$text")
    }

    private fun initObserves() {
        viewModel.userInputFirstNumber.observe(this, Observer {
            updateText(it)
        })

    }

    private fun initButton() {
        binding.btnNumberFive.setOnClickListener {
            viewModel.updateText("5")
        }
        binding.btnNumberTwo.setOnClickListener {
            viewModel.updateText("2")
        }
        binding.btnPlus.setOnClickListener {
          viewModel.printOperation( "+")
        }
        binding.btnMinus.setOnClickListener {
          viewModel.printOperation( "-")
        }
        binding.btnEquals.setOnClickListener {
            viewModel.operations(binding.editTextTextPersonName.text.toString())
            binding.tvResult.text = viewModel.finalResult.toString()
        }
    }
}



