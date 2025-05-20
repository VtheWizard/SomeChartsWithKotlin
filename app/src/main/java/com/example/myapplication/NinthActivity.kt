package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.charts.ScatterChart
import com.github.mikephil.charting.data.CombinedData
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet

class NinthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ninth)

        val chart = findViewById<CombinedChart>(R.id.combinedChart2)

        val scatterEntries = listOf(
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

        val (slope, intercept) = calculateLinearRegression(scatterEntries)
        val trendlineEntries = listOf(
            Entry(150f, slope * 150f + intercept),
            Entry(198f, slope * 198f + intercept)
        )

        val scatterDataSet = ScatterDataSet(scatterEntries, "height vs weight").apply {
            color = Color.BLUE
            var scatterShape = ScatterChart.ScatterShape.CIRCLE
            scatterShapeSize = 10f
        }

        val trendlineDataSet = LineDataSet(trendlineEntries, "Trendline").apply {
            color = Color.RED
            lineWidth = 2f
            setDrawValues(false)
            setDrawCircles(false)
        }

        val combinedData = CombinedData()
        combinedData.setData(ScatterData(scatterDataSet))
        combinedData.setData(LineData(trendlineDataSet))

        chart.description.isEnabled = false
        chart.axisRight.isEnabled = false
        chart.data = combinedData
        chart.invalidate()
    }

    private fun calculateLinearRegression(entries: List<Entry>): Pair<Float, Float> {
        val n = entries.size
        val sumX = entries.sumOf { it.x.toDouble() }
        val sumY = entries.sumOf { it.y.toDouble() }
        val sumXY = entries.sumOf { (it.x * it.y).toDouble() }
        val sumX2 = entries.sumOf { (it.x * it.x).toDouble() }

        val slope = ((n * sumXY) - (sumX * sumY)) / ((n * sumX2) - (sumX * sumX))
        val intercept = (sumY - (slope * sumX)) / n

        return Pair(slope.toFloat(), intercept.toFloat())
    }
}
