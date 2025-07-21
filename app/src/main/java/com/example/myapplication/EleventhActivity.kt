package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import net.objecthunter.exp4j.ExpressionBuilder

class EleventhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eleventh)

        val input = findViewById<EditText>(R.id.equationInput)
        val button = findViewById<Button>(R.id.plotButton)
        val chart = findViewById<LineChart>(R.id.chart)

        button.setOnClickListener {
            val expressionString = input.text.toString()
            val entries = mutableListOf<Entry>()
            //farely limited graphical calculator ok... no drawing circles pls... or do, if you cba doing some work yourself :P
            //try "sin(x) * log(x^2 + 1)" or "tan(sqrt(abs(x))) + sin(x^2)" for example
            //somehow got "exp(-x^2) * (sin(5x)^2 + cos(3x)^2) + log(x^2 + 1)" to plot
            for (x in -100..100) {
                val xVal = x / 10f
                try {
                    val expression = ExpressionBuilder(expressionString)
                        .variable("x")
                        .build()
                        .setVariable("x", xVal.toDouble())

                    val y = expression.evaluate().toFloat()
                    entries.add(Entry(xVal, y))

                } catch (e: Exception) {
                    input.error = "Invalid equation! Don't get too fancy!"
                    return@setOnClickListener
                }
            }
            val dataSet = LineDataSet(entries, "f(x)").apply {
                lineWidth = 2f
                color = resources.getColor(android.R.color.holo_blue_dark)
                setDrawCircles(false)
                setDrawValues(false)
            }

            chart.data = LineData(dataSet)
            chart.description.text = "Graph of your equation"
            chart.invalidate()      //finally get to the updating part of these charts with this
        }
    }
}