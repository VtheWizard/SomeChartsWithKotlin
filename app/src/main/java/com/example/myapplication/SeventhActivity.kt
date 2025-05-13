package com.example.myapplication

import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.github.mikephil.charting.charts.CandleStickChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry

class SeventhActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seventh)

        val chart = findViewById<CandleStickChart>(R.id.candleStickChart)
        val entries = listOf(
            CandleEntry(0f, 155f, 145f, 150f, 152f),
            CandleEntry(1f, 158f, 147f, 152f, 157f),
            CandleEntry(2f, 162f, 149f, 157f, 151f),
            CandleEntry(3f, 160f, 150f, 151f, 158f),
            CandleEntry(4f, 165f, 153f, 158f, 162f),
            CandleEntry(5f, 168f, 155f, 162f, 167f),
            CandleEntry(6f, 170f, 158f, 167f, 159f),
            CandleEntry(7f, 172f, 160f, 159f, 168f),
            CandleEntry(8f, 175f, 162f, 168f, 165f),
            CandleEntry(9f, 178f, 164f, 165f, 176f)
        )
        val dataSet = CandleDataSet(entries, "Stock Price")
        dataSet.shadowColor = Color.DKGRAY
        dataSet.shadowWidth = 0.8f
        dataSet.decreasingColor = Color.RED
        dataSet.decreasingPaintStyle = Paint.Style.FILL
        dataSet.increasingColor = Color.GREEN
        dataSet.increasingPaintStyle = Paint.Style.FILL
        dataSet.neutralColor = Color.LTGRAY
        dataSet.setDrawValues(false)
        chart.description.text = "10-Day Trading Overview"
        chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        chart.xAxis.setDrawGridLines(false)
        chart.axisLeft.setDrawGridLines(true)
        chart.axisRight.isEnabled = false
        chart.setScaleEnabled(true)
        chart.data = CandleData(dataSet)
        chart.invalidate()


    }
}