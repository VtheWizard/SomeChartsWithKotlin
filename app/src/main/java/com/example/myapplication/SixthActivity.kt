package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class SixthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixth)

        val chart = findViewById<ScatterChart>(R.id.scatterChart)
        val entries = listOf(
            Entry(150f, 45f),
            Entry(152f, 48f),
            Entry(155f, 50f),
            Entry(157f, 53f),
            Entry(160f, 55f),
            Entry(162f, 60f),
            Entry(165f, 58f),
            Entry(167f, 63f),
            Entry(170f, 67f),
            Entry(172f, 66f),
            Entry(175f, 72f),
            Entry(177f, 75f),
            Entry(180f, 78f),
            Entry(182f, 80f),
            Entry(185f, 85f),
            Entry(187f, 82f),
            Entry(190f, 90f),
            Entry(192f, 88f),
            Entry(195f, 93f),
            Entry(198f, 95f)
        )
        val dataSet = ScatterDataSet(entries, "Height and Weight")
        dataSet.setScatterShape(ScatterChart.ScatterShape.TRIANGLE) //try different shapes, maybe you could find out a way to add custom images
        dataSet.color = Color.DKGRAY
        dataSet.scatterShapeSize = 20f
        chart.description.text = "Scatter: height vs weight"
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        //chart.axisLeft.axisMinimum = 40f
        //chart.axisLeft.axisMaximum = 100f
        //chart.animateXY(1000, 1000)
        chart.data = ScatterData(dataSet)
        chart.invalidate()         //this will also reset the chart if needed at some point


    }
}