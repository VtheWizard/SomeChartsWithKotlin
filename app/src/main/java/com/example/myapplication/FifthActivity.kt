package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.BubbleChart
import com.github.mikephil.charting.data.BubbleData
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry
import com.github.mikephil.charting.utils.ColorTemplate

class FifthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fifth)

        val chart = findViewById<BubbleChart>(R.id.bubbleChart)
        val entries = listOf(
            BubbleEntry(1f, 30f, 10f),
            BubbleEntry(2f, 50f, 15f),
            BubbleEntry(3f, 20f, 8f),
            BubbleEntry(4f, 70f, 20f)
        )
        val dataSet = BubbleDataSet(entries, "likes, shares, reach")
        val xAxis = chart.xAxis
        // uncommenting will result bubbles not clipping the sides
        // as minimum and maximum ranges are set to appropriate values
        //xAxis.axisMinimum = 0f
        //xAxis.axisMaximum = 5f
        dataSet.setDrawValues(true)
        dataSet.color = ColorTemplate.getHoloBlue()
        dataSet.setColor(Color.BLUE, 150)
        //chart.animateY(1000)            //simple animation
        chart.description.text = "Bubble Chart on Social media posts"
        chart.data = BubbleData(dataSet)
        chart.invalidate()        //this will also reset the chart if needed at some point


    }
}


