package com.hencesimplified.weatherapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val searchBtn = findViewById<FloatingActionButton>(R.id.floatingSearch)
        val searchTxt = findViewById<EditText>(R.id.txtSearch)
        val cardViewShake = findViewById<CardView>(R.id.cardview)
        val shakeAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.shake)


        searchBtn.setOnClickListener {

            val cityName = searchTxt.text.toString().toUpperCase()

            if (cityName == "") {
                cardViewShake.startAnimation(shakeAnimation)
                //Toast.makeText(applicationContext,"Enter City Name",Toast.LENGTH_SHORT).show()
                Snackbar.make(it, "Enter City Name", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.parseColor("#96bb7c"))
                    .setTextColor(Color.parseColor("#ffffff")).show()
            } else {
                val intent = Intent(this, WeatherActivity::class.java)
                // To pass any data to next activity
                intent.putExtra("cityName", cityName)
                // start your next activity
                startActivity(intent)
                overridePendingTransition(R.anim.right_enter, R.anim.left_out)
            }

        }

    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Warning!")
        builder.setMessage("Are you sure, you want to exit?")
        builder.setPositiveButton("Yes") { dialogInterface, i ->
            val exitIntent = Intent(Intent.ACTION_MAIN)
            exitIntent.addCategory(Intent.CATEGORY_HOME)
            exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(exitIntent)
        }
        builder.setNegativeButton("No") { dialogInterface, i ->
            dialogInterface.cancel();
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

}

