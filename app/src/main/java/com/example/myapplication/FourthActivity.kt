package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)

        val chart = findViewById<RadarChart>(R.id.radarChart)
        val entries = listOf(
            RadarEntry(9f),
            RadarEntry(7f),
            RadarEntry(6f),
            RadarEntry(8f),
            RadarEntry(1f),
            RadarEntry(3f)
        )
        val dataSet = RadarDataSet(entries, "Player Statistics")
        dataSet.color = Color.MAGENTA
        dataSet.setDrawFilled(true)
        val yAxis = chart.yAxis
        yAxis.axisMinimum = 0f                      //chart starts at 0 instead of whatever the lowest value is
        yAxis.axisMaximum = 8f
        val labels = listOf("Agility", "Intellect", "Stamina", "Spirit", "Strength", "Player Skill")
        chart.data = RadarData(dataSet)
        chart.webLineWidth = 1f
        chart.webColorInner = Color.LTGRAY
        chart.webAlpha = 150
        chart.xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        //chart.animateXY(1000, 1000)
        chart.description.text = "Radar Chart on a players statistics"
        chart.webColor = Color.LTGRAY
        chart.invalidate()        //this will also reset the chart if needed at some point


    }
}