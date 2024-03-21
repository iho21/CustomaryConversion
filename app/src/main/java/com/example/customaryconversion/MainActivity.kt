package com.example.customaryconversion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.WindowInsetsCompat
import android.widget.*
import androidx.core.view.WindowInsetsCompat.*
import android.view.View
import android.text.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputNumber: EditText = findViewById(R.id.inputNumber)
        val outText: TextView = findViewById(R.id.outText)
        val inSpinner: Spinner = findViewById(R.id.inputSpinner)
        val outSpinner: Spinner = findViewById(R.id.outputSpinner)

        val lengths = resources.getStringArray(R.array.Lengths)

        // Set up adapters for spinners
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, lengths)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        inSpinner.adapter = adapter
        outSpinner.adapter = adapter

        // Set initial selection for both spinners (optional)
        inSpinner.setSelection(0)
        outSpinner.setSelection(0)

        // Set up item selected listeners for both spinners
        inSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateConversionResult()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        outSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateConversionResult()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        // Set up text change listener for input number EditText
        inputNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                updateConversionResult()
            }
        })
    }

    private fun updateConversionResult() {
        val inputNumber: EditText = findViewById(R.id.inputNumber)
        val outText: TextView = findViewById(R.id.outText)
        val inSpinner: Spinner = findViewById(R.id.inputSpinner)
        val outSpinner: Spinner = findViewById(R.id.outputSpinner)

        val lengths = resources.getStringArray(R.array.Lengths)

        val textEntered: Int = inputNumber.text.toString().toIntOrNull() ?: 0
        val inSpinnerItem = lengths[inSpinner.selectedItemPosition]
        val outSpinnerItem = lengths[outSpinner.selectedItemPosition]

        var result = 0
        if (inSpinnerItem == "in" && outSpinnerItem == "ft") {
            result = textEntered / 12
        } else if (inSpinnerItem == "in" && outSpinnerItem == "mi") {
            result = textEntered / 63360
        }

        outText.text = result.toString()
    }
}




