package com.example.aptituder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onBackPressed() {
        finishAffinity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val NumericalAptitude = findViewById<Button>(R.id.NumApt)
        val ComputerScience = findViewById<Button>(R.id.CompApt)
        val Sportsaptitude = findViewById<Button>(R.id.SprtApt)
        val Physicssaptitude = findViewById<Button>(R.id.PhysApt)

        NumericalAptitude.setOnClickListener {
            startActivity(Intent(this@MainActivity,Numerical_Aptitude::class.java))
        }

        ComputerScience.setOnClickListener {
            startActivity(Intent(this@MainActivity,Computer_science_aptitude::class.java))
        }

        Sportsaptitude.setOnClickListener {
            startActivity(Intent(this@MainActivity,Sports_aptitude::class.java))

        }

        Physicssaptitude.setOnClickListener {
            startActivity(Intent(this,Physics_aptitude::class.java))
        }



    }
}