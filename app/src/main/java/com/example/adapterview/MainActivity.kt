package com.example.adapterview

import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val canvas = findViewById<View>(R.id.canvas)
        val addButton = findViewById<Button>(R.id.addButton)
        val colorEditText = findViewById<EditText>(R.id.colornameEditText)

        //arrayOf cannot be changed, arrayListOf can be changed, less efficient, but more dynamic or flexible
        val colors = arrayListOf("Blue", "White", "Red", "Yellow", "Green", "Purple", "Gray")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, colors)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run {
                    //val color = (this as TextView).text.toString()
                    val color = getItemAtPosition(p2).toString() //returns an uncategorized object aka anything is this "any"

                    canvas.setBackgroundColor(Color.parseColor(color))
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }

        addButton.setOnClickListener {
            colors.add(colorEditText.text.toString())
            adapter.notifyDataSetChanged()
        }
    }
}