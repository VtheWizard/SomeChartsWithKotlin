Some hopefully acceptable charts made with MPAndroidChart.

Android studio really wanted all the files in master branch so that is where you find all of that.

Actualy important bits in app/src/main/java/com/example/myapplication in the master branch.


SomeChartsWithKotlin

Welcome to the MPAndroidChart example project!
This project is designed for students who want to learn how to create visual charts in Android apps using Kotlin.

🌐 Contents

LineChart

BarChart

PieChart

🚀 Getting Started

Clone the repository:

```git clone https://github.com/VtheWizard/SomeChartsWithKotlin.git```

Open the project in Android Studio

Make sure your build.gradle (Module: app) includes the following line:

```implementation 'com.github.PhilJay:MPAndroidChart:3.1.0'```

Sync Gradle

🎨 Chart Examples

1. LineChartActivity.kt

Line chart that displays a simple time series.
```
val entries = listOf(
    Entry(0f, 1f),
    Entry(1f, 3f),
    Entry(2f, 2f),
    Entry(3f, 5f)
)
val dataSet = LineDataSet(entries, "Sample Data")
dataSet.color = Color.BLUE
val data = LineData(dataSet)
lineChart.data = data
lineChart.invalidate()
```
2. BarChartActivity.kt

Bar chart for comparing values.
```
val entries = listOf(
    BarEntry(0f, 4f),
    BarEntry(1f, 6f),
    BarEntry(2f, 8f)
)
val dataSet = BarDataSet(entries, "Bar Data")
dataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
barChart.data = BarData(dataSet)
barChart.invalidate()
```
3. PieChartActivity.kt

Pie chart for showing category proportions.
```
val entries = listOf(
    PieEntry(40f, "A"),
    PieEntry(30f, "B"),
    PieEntry(30f, "C")
)
val dataSet = PieDataSet(entries, "Distribution")
dataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
pieChart.data = PieData(dataSet)
pieChart.invalidate()
```
📝 Student Exercises

Try adding date labels to the X-axis in LineChart

Change the chart colors and add animations

Create a new activity that combines multiple LineDataSets in one chart

🎓 Useful Links

MPAndroidChart GitHub https://github.com/PhilJay/MPAndroidChart
