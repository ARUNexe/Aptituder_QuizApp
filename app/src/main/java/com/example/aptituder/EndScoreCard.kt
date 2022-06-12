package com.example.aptituder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.TextView

class EndScoreCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_score_card)

        val Score = findViewById<TextView>(R.id.ScoreTv)
        val wish = findViewById<TextView>(R.id.wishTv)
        val menuBtn = findViewById<Button>(R.id.menuBtn)

        var InstanceScore = intent.getIntExtra("score",0)

        Score.text = InstanceScore.toString()

        if(InstanceScore>=10)
            wish.text = ("  Nice work  ")
        if(InstanceScore<5)
            wish.text = ("  can do better  ")

        val C_Subject = intent.getIntExtra("Current_level",1)


        menuBtn.setOnClickListener {

            var newintent = Intent(this,MainActivity::class.java)

            if(C_Subject==1) {
                newintent = Intent(this, Numerical_Aptitude::class.java)
           }
           if (C_Subject==2) {
                newintent = Intent(this,Computer_science_aptitude::class.java)
           }
            if (C_Subject==3) {
                newintent = Intent(this,Sports_aptitude::class.java)
            }
            if (C_Subject==4) {
                newintent = Intent(this,Physics_aptitude::class.java)
            }

           startActivity(newintent)
        }

    }

}