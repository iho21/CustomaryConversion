package com.example.customaryconversion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.WindowInsetsCompat
import android.widget.*
import androidx.core.view.WindowInsetsCompat.*
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        lateinit var inputNumber: EditText

        val lengths = resources.getStringArray(R.array.Lengths)
        val inSpinner = findViewById<Spinner>(R.id.inputSpinner)
        if (inSpinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, lengths
            )
            inSpinner.adapter = adapter
            object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    if(getString(R.string.selected_item) == "in") {

                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action

                }
            }
            val outSpinner = findViewById<Spinner>(R.id.outputSpinner)

            if (outSpinner != null) {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, lengths
                )
                outSpinner.adapter = adapter
                object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.selected_item) + " " +
                                    "" + lengths[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action

                    }
                }
            }
        }
    }
}
