package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class EighthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eighth)

        val barEntries = listOf(
            BarEntry(1f, 30f),
            BarEntry(2f, 80f),
            BarEntry(3f, 60f),
            BarEntry(4f, 50f)
        )
        val lineEntries = listOf(
            Entry(1f, 20f),
            Entry(2f, 60f),
            Entry(3f, 55f),
            Entry(4f, 70f)
        )
        val barDataSet = BarDataSet(barEntries, "Revenue").apply {
            color = Color.rgb(100, 149, 237)
            barBorderWidth = 1f
        }
        val lineDataSet = LineDataSet(lineEntries, "Growth").apply {
            color = Color.RED
            lineWidth = 3f
            setDrawCircles(true)
            setCircleColor(Color.RED)
            setDrawValues(false)
            mode = LineDataSet.Mode.CUBIC_BEZIER
        }

        val combinedChart = findViewById<CombinedChart>(R.id.combinedChart)
        val xAxis = combinedChart.xAxis
        //xAxis.axisMinimum = 0f
        //xAxis.axisMaximum = 5f
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        //xAxis.valueFormatter = IndexAxisValueFormatter(listOf("", "Q1", "Q2", "Q3", "Q4", ""))
        val barData = BarData(barDataSet)
        val lineData = LineData(lineDataSet)
        val combinedData = CombinedData() //combining data
        combinedData.setData(barData)
        combinedData.setData(lineData)
        combinedChart.data = combinedData
        combinedChart.description.text = "Revenue vs. Growth"
        combinedChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        combinedChart.xAxis.granularity = 1f
        combinedChart.axisRight.isEnabled = false
        //combinedChart.animateY(1000)
        combinedChart.invalidate()

    }
}