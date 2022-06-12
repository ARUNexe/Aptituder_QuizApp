package com.example.aptituder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class Computer_science_aptitude : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer_science_aptitude)

        val Level1Btn = findViewById<Button>(R.id.level1)
        val Level2Btn = findViewById<Button>(R.id.level2)
        val Level3Btn = findViewById<Button>(R.id.level3)

        val level2_lock = findViewById<ImageView>(R.id.level2_lock)
        val level3_lock = findViewById<ImageView>(R.id.level3_lock)

        val level_1_icon = findViewById<ImageView>(R.id.prize1)
        val level_2_icon = findViewById<ImageView>(R.id.prize2)
        val level_3_icon = findViewById<ImageView>(R.id.prize3)

        level_1_icon.isVisible = false
        level_2_icon.isVisible = false
        level_3_icon.isVisible = false

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        Level2Btn.isEnabled = false
        Level3Btn.isEnabled = false


        var level2_img = sharedPreference.getBoolean("Sub2_level2",false)
        var level3_img = sharedPreference.getBoolean("Sub2_level3",false)

        var prize_1 = sharedPreference.getBoolean("Sub2_level1_prize",false)
        var prize_2 = sharedPreference.getBoolean("Sub2_level2_prize",false)
        var prize_3 = sharedPreference.getBoolean("Sub2_level3_prize",false)



        if(level2_img==true)
        {
            level2_lock.isInvisible = true
            Level2Btn.isEnabled = true
        }
        if(level3_img==true)
        {
            level3_lock.isInvisible = true
            Level3Btn.isEnabled = true
        }
        if(prize_1==true)
            level_1_icon.isVisible = true
        if(prize_2==true)
            level_2_icon.isVisible = true
        if(prize_3==true)
            level_3_icon.isVisible = true






        Level1Btn.setOnClickListener {
            val intent = Intent(this,QuestionPage::class.java)
            intent.putExtra("subject",2)
            intent.putExtra("level",1)
            startActivity(intent)
            //startActivity(Intent(this@Numerical_Aptitude, QuestionPage::class.java))

        }

        Level2Btn.setOnClickListener {
            val intent = Intent(this,QuestionPage::class.java)
            intent.putExtra("subject",2)
            intent.putExtra("level",2)
            startActivity(intent)
            //startActivity(Intent(this@Numerical_Aptitude, QuestionPage::class.java))

        }

        Level3Btn.setOnClickListener {
            val intent = Intent(this,QuestionPage::class.java)
            intent.putExtra("subject",2)
            intent.putExtra("level",3)
            startActivity(intent)
            //startActivity(Intent(this@Numerical_Aptitude, QuestionPage::class.java))

        }



    }
}