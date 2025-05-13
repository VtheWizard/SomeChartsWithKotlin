package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)

        val chart = findViewById<LineChart>(R.id.lineChart)
        val entries = listOf(
            Entry(0f, 120f),
            Entry(1f, 150f),
            Entry(2f, 180f),
            Entry(3f, 90f),
            Entry(4f, 200f),
            Entry(5f, 170f),
            Entry(6f, 250f)
        )
        val dataSet = LineDataSet(entries, "Faked Website traffic")
        chart.setDrawGridBackground(false)
        //dataSet.setDrawFilled(true)                 //fills the area below line
        //chart.isDragEnabled = true
        chart.setScaleEnabled(true)
        //chart.animateX(1000, Easing.EaseInCubic)
        chart.description.text = "Line Chart showing Website traffic"
        chart.data = LineData(dataSet)
        chart.invalidate()

    }
}