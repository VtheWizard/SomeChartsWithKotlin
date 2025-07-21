package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button10: Button = findViewById(R.id.button10)
        val button11: Button = findViewById(R.id.button11)

        //uncomment lines to compare how charts change
        //On Click listeners on all buttons to go to different charts in their own activities
        button1.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this, SixthActivity::class.java)
            startActivity(intent)
        }
        button7.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent = Intent(this, EighthActivity::class.java)
            startActivity(intent)
        }
        button9.setOnClickListener {
            val intent = Intent(this, NinthActivity::class.java)
            startActivity(intent)
        }
        button10.setOnClickListener {
            val intent = Intent(this, tenthActivity::class.java)
            startActivity(intent)
        }
        button11.setOnClickListener {
            val intent = Intent(this, EleventhActivity::class.java)
            startActivity(intent)
        }

    }
}