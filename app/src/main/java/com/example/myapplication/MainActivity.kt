package com.example.myapplication


import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.*


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
        viewModel.userInputFirstNumber.observe(this, androidx.lifecycle.Observer {
            updateText(it)
            Log.d(TAG, it)
        })

    }

    override fun onClick(view: View?) {

        // стало
        when (view!!.id) {
            R.id.btnNumberTwo -> viewModel.updateText("2")
            R.id.btnNumberFive -> viewModel.updateText("5")
            R.id.btnPlus -> viewModel.updateText("+")
            R.id.btnEquals -> {
                viewModel.update(binding.editTextTextPersonName.text.toString())
                binding.editTextTextPersonName.text = viewModel.finalResult.toString().toEditable()
            }
        }
    }
    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
}



