package com.hencesimplified.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchBtn=findViewById<Button>(R.id.btnSearch)
        val searchtxt=findViewById<EditText>(R.id.TxtSearch)

        searchBtn.setOnClickListener{
            val cityName=searchtxt.text.toString().toUpperCase()

            val intent = Intent(this, weather_page::class.java)
            // To pass any data to next activity
            intent.putExtra("cityName", cityName)
            // start your next activity
            startActivity(intent)

        }

    }

}

