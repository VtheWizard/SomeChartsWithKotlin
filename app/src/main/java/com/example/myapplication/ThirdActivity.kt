package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        val chart = findViewById<PieChart>(R.id.pieChart)
        val entries = listOf(
            PieEntry(1515000000f, "English"),
            PieEntry(1140000000f, "Mandarin Chinese"),
            PieEntry(559000000f, "Spanish"),
            PieEntry(332000000f, "Standard Arabic"),
            PieEntry(312000000f, "French")
        )
        val dataSet = PieDataSet(entries, "Most spoken Languages")
        dataSet.colors = listOf(
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.CYAN,
            Color.MAGENTA
        )
        chart.setUsePercentValues(true)
        //chart.setDrawHoleEnabled(true)          //enables the whole in the middle
        //chart.holeRadius = 40f
        //chart.transparentCircleRadius = 60f     //two-tone sectors
        chart.centerText = "Most spoken languages"
        //chart.animateXY(1400, 1400)             //animation
        chart.legend.isWordWrapEnabled = true
        chart.data = PieData(dataSet)
        chart.invalidate()       //this will also reset the chart if needed at some point

    }
}