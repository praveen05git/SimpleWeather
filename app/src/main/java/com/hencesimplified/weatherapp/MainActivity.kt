package com.hencesimplified.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlin.math.E

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchBtn=findViewById<FloatingActionButton>(R.id.floatingSearch)
        val searchtxt=findViewById<EditText>(R.id.txtSearch)


        searchBtn.setOnClickListener{

            val cityName=searchtxt.text.toString().toUpperCase()

            if(cityName.equals(""))
            {
                Toast.makeText(applicationContext,"Enter City Name",Toast.LENGTH_SHORT).show()
                //Snackbar.make(it,"Enter City Name",Snackbar.LENGTH_SHORT).setBackgroundTint().show()
            }
            else
            {
                val intent = Intent(this, weather_page::class.java)
                // To pass any data to next activity
                intent.putExtra("cityName", cityName)
                // start your next activity
                startActivity(intent)
                overridePendingTransition(R.anim.right_enter,R.anim.left_out)
            }

        }

    }

    override fun onBackPressed()
    {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Warning!")
        builder.setMessage("Are you sure, you want to exit?")
        builder.setPositiveButton("Yes"){dialogInterface, i ->
            val ExitIntent = Intent(Intent.ACTION_MAIN)
            ExitIntent.addCategory(Intent.CATEGORY_HOME)
            ExitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(ExitIntent)
        }
        builder.setNegativeButton("No"){dialogInterface, i ->
            dialogInterface.cancel();
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

}

