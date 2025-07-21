package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val chart = findViewById<BarChart>(R.id.barChart)
        val entries = listOf(
            BarEntry(0f, 40f),
            BarEntry(1f, 50f),
            BarEntry(2f, 45f),
            BarEntry(3f, 70f),
            BarEntry(4f, 60f),
            BarEntry(5f, 90f),
            BarEntry(6f, 85f),
            BarEntry(7f, 95f),
            BarEntry(8f, 100f),
            BarEntry(9f, 110f),
            BarEntry(10f, 105f),
            BarEntry(11f, 120f)
        )
        val dataSet = BarDataSet(entries, "Monthly Sales")
        dataSet.colors = listOf(                //giving the bars some color
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA,
            Color.LTGRAY,
            Color.DKGRAY,
            Color.BLACK,
            Color.GRAY,
            Color.parseColor("#FFA500"),
            Color.parseColor("#00FFFF")
        )
        chart.axisRight.isEnabled = false
        chart.xAxis.granularity = 1f
        //chart.animateY(1800)            //simple animation that rises the bars from the x axis
        chart.description.text = "Bar Chart on some companys monthly sales" //adds a description to the chart
        chart.data = BarData(dataSet)
        chart.invalidate()      //this will also reset the chart if needed at some point

    }
}