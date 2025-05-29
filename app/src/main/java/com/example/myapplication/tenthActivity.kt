package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet



class tenthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tenth)

        val chart = findViewById<CombinedChart>(R.id.parabolicChart)

        //making a combined chart for height over time for a ball thrown in the air
        //using a scatter chart and parabolic line chart combined

        // Physics parameters
        val h0 = 1.5f         // initial height (meters)
        val v0 = 10f          // initial upward velocity (m/s)
        val g = 9.8f          // gravity (m/s²)
        val timeStep = 0.1f   // seconds between points
        val maxTime = 2.5f    // total duration

        // Generate parabolic line (ideal curve)
        val lineEntries = mutableListOf<Entry>()
        var t = 0f
        while (t <= maxTime) {
            val height = h0 + v0 * t - 0.5f * g * t * t
            lineEntries.add(Entry(t, height))
            t += timeStep
        }

        val lineDataSet = LineDataSet(lineEntries, "Ideal Trajectory").apply {
            color = Color.RED
            lineWidth = 2f
            setDrawCircles(false)
            setDrawValues(false)
        }

        // Simulated real scatter points (measured data)
        val scatterEntries = listOf(
            Entry(0.0f, 1.5f),
            Entry(0.2f, 2.9f),
            Entry(0.4f, 4.3f),
            Entry(0.6f, 5.4f),
            Entry(0.8f, 6.0f),
            Entry(1.0f, 6.3f),
            Entry(1.2f, 6.2f),
            Entry(1.4f, 5.8f),
            Entry(1.6f, 5.1f),
            Entry(1.8f, 4.2f),
            Entry(2.0f, 3.0f),
            Entry(2.2f, 1.7f),
            Entry(2.4f, 0.8f),
            Entry(2.5f, 0.5f)
        )

        val scatterDataSet = ScatterDataSet(scatterEntries, "Measured Points").apply {
            color = Color.BLUE
            var scatterShape = ScatterChart.ScatterShape.CIRCLE
            scatterShapeSize = 10f
        }

        // Combine both datasets
        val combinedData = CombinedData().apply {
            setData(LineData(lineDataSet))
            setData(ScatterData(scatterDataSet))
        }

        chart.apply {
            data = combinedData
            description.isEnabled = false
            axisRight.isEnabled = false
            axisLeft.axisMinimum = 0f
            xAxis.granularity = 0.1f
            xAxis.axisMinimum = 0f
            xAxis.axisMaximum = maxTime + 0.5f
            animateXY(1000, 1000)
            invalidate()
        }

    }
}