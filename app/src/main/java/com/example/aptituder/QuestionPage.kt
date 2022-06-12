package com.example.aptituder

import android.R.attr.button
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import java.lang.reflect.Array


class QuestionPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)

        //question teextview
        val Question = findViewById<TextView>(R.id.QuestionTv)
        val QuestionCounter = findViewById<TextView>(R.id.QuestionNumberTv)

        //options Buttons
        val Option1 = findViewById<Button>(R.id.ansA)
        val Option2 = findViewById<Button>(R.id.ansB)
        val Option3 = findViewById<Button>(R.id.ansC)
        val Option4 = findViewById<Button>(R.id.ansD)

        //Next and skip Buttons
        val nextBtn = findViewById<Button>(R.id.NextBtn)
        val HintBtn = findViewById<Button>(R.id.HintBtn)
        val HintCounter = findViewById<TextView>(R.id.HintRemainingTv)

        var ScoreCounter = 0

        var optionhider = true
        var hintRemainding = 3

        val subject = intent.getIntExtra("subject",0)
        val level = intent.getIntExtra("level",0)

        //Question DEFAULT
        var questions = getResources().getStringArray(R.array.Numapt_1_opt_D) //just a default spaceholder  for question array
        // 4 options
        var options1 = getResources().getStringArray(R.array.Numapt_1_opt_D)
        var options2 = getResources().getStringArray(R.array.Numapt_1_opt_D)
        var options3 = getResources().getStringArray(R.array.Numapt_1_opt_D)
        var options4 = getResources().getStringArray(R.array.Numapt_1_opt_D)
        // answer
        var answers = getResources().getStringArray(R.array.Numapt_1_opt_D)

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)



        // LEVEL_1 Subject_1
        if(subject==1 && level==2)
        {
            questions = getResources().getStringArray(R.array.NumApt_1)
            options1 = getResources().getStringArray(R.array.Numapt_1_opt_A)
            options2 = getResources().getStringArray(R.array.Numapt_1_opt_B)
            options3 = getResources().getStringArray(R.array.Numapt_1_opt_C)
            options4 = getResources().getStringArray(R.array.Numapt_1_opt_D)
            answers = getResources().getStringArray(R.array.Numapt_Answers_1)
        }

        if(subject==1 && level==1)
        {
            questions = getResources().getStringArray(R.array.Numapt_2)
            options1 = getResources().getStringArray(R.array.Numapt_2_optA)
            options2 = getResources().getStringArray(R.array.Numapt_2_optB)
            options3 = getResources().getStringArray(R.array.Numapt_2_optC)
            options4 = getResources().getStringArray(R.array.Numapt_2_optD)
            answers = getResources().getStringArray(R.array.Numapt_Answers_2)
        }
        if(subject==1 && level==3)
        {
            questions = getResources().getStringArray(R.array.Numapt_3)
            options1 = getResources().getStringArray(R.array.Numapt_3_optA)
            options2 = getResources().getStringArray(R.array.Numapt_3_optB)
            options3 = getResources().getStringArray(R.array.Numapt_3_optC)
            options4 = getResources().getStringArray(R.array.Numapt_3_optD)
            answers = getResources().getStringArray(R.array.Numapt_Answers_3)
        }

        if(subject==2 && level==1)
        {
            questions = getResources().getStringArray(R.array.Compapt_1_Questions)
            options1 = getResources().getStringArray(R.array.Compapt_1_OptA)
            options2 = getResources().getStringArray(R.array.Compapt_1_OptB)
            options3 = getResources().getStringArray(R.array.Compapt_1_OptC)
            options4 = getResources().getStringArray(R.array.Compapt_1_OptD)
            answers = getResources().getStringArray(R.array.Compapt_1_answers)
        }

        if(subject==2 && level==2)
        {
            questions = getResources().getStringArray(R.array.Compapt_2_Questions)
            options1 = getResources().getStringArray(R.array.Compapt_2_OptA)
            options2 = getResources().getStringArray(R.array.Compapt_2_OptB)
            options3 = getResources().getStringArray(R.array.Compapt_2_OptC)
            options4 = getResources().getStringArray(R.array.Compapt_2_OptD)
            answers = getResources().getStringArray(R.array.Compapt_2_answers)
        }

        if(subject==2 && level==3)
        {
            questions = getResources().getStringArray(R.array.Compapt_3_Questions)
            options1 = getResources().getStringArray(R.array.Compapt_3_optA)
            options2 = getResources().getStringArray(R.array.Compapt_3_optB)
            options3 = getResources().getStringArray(R.array.Compapt_3_optC)
            options4 = getResources().getStringArray(R.array.Compapt_3_optD)
            answers = getResources().getStringArray(R.array.Compapt_3_answers)
        }

        if(subject==3 && level==1)
        {
            questions = getResources().getStringArray(R.array.Sprtapt_1_Questions)
            options1 = getResources().getStringArray(R.array.Sprtapt_1_optA)
            options2 = getResources().getStringArray(R.array.Sprtapt_1_optB)
            options3 = getResources().getStringArray(R.array.Sprtapt_1_optC)
            options4 = getResources().getStringArray(R.array.Sprtapt_1_optD)
            answers = getResources().getStringArray(R.array.Sprtapt_1_answers)
        }

        if(subject==3 && level==2)
        {
            questions = getResources().getStringArray(R.array.Sprtapt_2_Questions)
            options1 = getResources().getStringArray(R.array.Sprtapt_2_optA)
            options2 = getResources().getStringArray(R.array.Sprtapt_2_optB)
            options3 = getResources().getStringArray(R.array.Sprtapt_2_optC)
            options4 = getResources().getStringArray(R.array.Sprtapt_2_optD)
            answers = getResources().getStringArray(R.array.Sprtapt_2_answers)
        }

        if(subject==4 && level==1)
        {
            questions = getResources().getStringArray(R.array.Physapt_1_Questions)
            options1 = getResources().getStringArray(R.array.Physapt_1_optA)
            options2 = getResources().getStringArray(R.array.Physapt_1_optB)
            options3 = getResources().getStringArray(R.array.Physapt_1_optC)
            options4 = getResources().getStringArray(R.array.Physapt_1_optD)
            answers = getResources().getStringArray(R.array.Physapt_1_answers)
        }

        if(subject==4 && level==2)
        {
            questions = getResources().getStringArray(R.array.Physapt_2_Questions)
            options1 = getResources().getStringArray(R.array.Physapt_2_optA)
            options2 = getResources().getStringArray(R.array.Physapt_2_optB)
            options3 = getResources().getStringArray(R.array.Physapt_2_optC)
            options4 = getResources().getStringArray(R.array.Physapt_2_optD)
            answers = getResources().getStringArray(R.array.Physapt_2_answers)
        }
        if(subject==4 && level==3)
        {
            questions = getResources().getStringArray(R.array.Physapt_3_Questions)
            options1 = getResources().getStringArray(R.array.Physapt_3_optA)
            options2 = getResources().getStringArray(R.array.Physapt_3_optB)
            options3 = getResources().getStringArray(R.array.Physapt_3_optC)
            options4 = getResources().getStringArray(R.array.Physapt_3_optD)
            answers = getResources().getStringArray(R.array.Physapt_3_answers)
        }

        if(subject==3 && level==3)
        {
            questions = getResources().getStringArray(R.array.Sprtapt_3_Questions)
            options1 = getResources().getStringArray(R.array.Sprtapt_3_optA)
            options2 = getResources().getStringArray(R.array.Sprtapt_3_optB)
            options3 = getResources().getStringArray(R.array.Sprtapt_3_optC)
            options4 = getResources().getStringArray(R.array.Sprtapt_3_optD)
            answers = getResources().getStringArray(R.array.Sprtapt_3_answers)
        }






        if(optionhider==true)
        {
            Option1.isVisible = false
            Option2.isVisible = false
            Option3.isVisible = false
            Option4.isVisible = false
        }
        var Qno = 1


        fun ClickDisabler()
        {
            Option1.isClickable = false
            Option2.isClickable = false
            Option3.isClickable = false
            Option4.isClickable = false
        }



        nextBtn.setOnClickListener {

            if (Qno>15)
                nextBtn.isClickable = false




            optionhider = false
            if (optionhider==false)
            {
                Option1.isVisible = true
                Option2.isVisible = true
                Option3.isVisible = true
                Option4.isVisible = true
            }

            Option1.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#263837")))
            Option2.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#263837")))
            Option3.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#263837")))
            Option4.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#263837")))

            fun unlockupdater(score : Int, levels : Int,sub : Int)
            {

                // numerical button starts
                if(level==1 && sub==1 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub1_level2",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub1_level1_prize",true)
                        editor.apply()
                    }
                }
                if(level==2 && sub==1 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub1_level3",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub1_level2_prize",true)
                        editor.apply()
                    }
                }

                if(level==3 && sub==1 && score==15)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub1_level3_prize",true)
                    editor.apply()
                }
                // numerical button ends



                // CS button starts
                if(level==1 && sub==2 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub2_level2",true)


            editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub2_level1_prize",true)
                        editor.apply()
                    }

                }

                if(level==2 && sub==2 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub2_level3",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub2_level2_prize",true)
                        editor.apply()
                    }
                }

                if(score==15 && sub==2 && level==3){
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub2_level3_prize",true)
                    editor.apply()
                }
                // CS button ends



                // sports button begins
                if(level==1 && sub==3 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub3_level2",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub3_level1_prize",true)
                        editor.apply()
                    }
                }
                if(level==2 && sub==3 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub3_level3",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub3_level2_prize",true)
                        editor.apply()
                    }
                }

                if(score==15 && sub==3 && level==3){
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub3_level3_prize",true)
                    editor.apply()
                }
                // sports button ends


                // physics button begins
                if(level==1 && sub==4 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub4_level2",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub4_level1_prize",true)
                        editor.apply()
                    }
                }
                if(level==2 && sub==4 && score>10)
                {
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub4_level3",true)
                    editor.apply()
                    if(score==15){
                        var editor = sharedPreference.edit()
                        editor.putBoolean("Sub4_level2_prize",true)
                        editor.apply()
                    }
                }

                if(score==15 && sub==4 && level==3){
                    var editor = sharedPreference.edit()
                    editor.putBoolean("Sub4_level3_prize",true)
                    editor.apply()
                }
                // physics button ends
            }

            if(Qno<=15) {
                QuestionCounter.text = ("Question : ${Qno}/15")

                var NextQuestion = questions[Qno - 1]
                Qno += 1
                Question.text = NextQuestion.toString()

                var InstanceOprion1 = options1[Qno-2]
                var InstanceOprion2 = options2[Qno-2]
                var InstanceOprion3 = options3[Qno-2]
                var InstanceOprion4 = options4[Qno-2]


                Option1.text = InstanceOprion1.toString()
                Option2.text = InstanceOprion2.toString()
                Option3.text = InstanceOprion3.toString()
                Option4.text = InstanceOprion4.toString()

            }
            else {
                Toast.makeText(this, " Your Score ${ScoreCounter.toString()}/15", Toast.LENGTH_SHORT).show()
                ClickDisabler()
                unlockupdater(ScoreCounter,level,subject)
                val intent = Intent(this, EndScoreCard::class.java)
                intent.putExtra("score",ScoreCounter)
                intent.putExtra("Current_level",subject)
                startActivity(intent)
            }








            fun Correctchecker(optionClicked : String)
            {



                var correctAnswer = answers[Qno-2]
                if(optionClicked==correctAnswer)
                {
                    ScoreCounter+=1

                    if(optionClicked=="1")
                        Option1.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))
                    if(optionClicked=="2")
                        Option2.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))
                    if(optionClicked=="3")
                        Option3.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))
                    if(optionClicked=="4")
                        Option4.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))


                }
                else
                {
                    //Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()

                    if(optionClicked=="1")
                        Option1.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                    if(optionClicked=="2")
                        Option2.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                    if(optionClicked=="3")
                        Option3.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                    if(optionClicked=="4")
                        Option4.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))

                    if(correctAnswer=="1")
                        Option1.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))
                    if(correctAnswer=="2")
                        Option2.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))
                    if(correctAnswer=="3")
                        Option3.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))
                    if(correctAnswer=="4")
                        Option4.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#068f41")))

                }

                ClickDisabler()


            }




            Option1.setOnClickListener {
                Correctchecker("1")
            }
            Option2.setOnClickListener {
                Correctchecker("2")
            }
            Option3.setOnClickListener {
                Correctchecker("3")
            }
            Option4.setOnClickListener {
                Correctchecker("4")
            }


            HintBtn.setOnClickListener {


                if(hintRemainding>0)
                {
                    var correctAnswer = answers[Qno-2]
                    if(correctAnswer=="1" || correctAnswer=="2")
                    {
                        Option3.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                        Option4.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                    }
                    if(correctAnswer=="3" || correctAnswer=="4")
                    {
                        Option1.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                        Option2.backgroundTintList = (ColorStateList.valueOf(Color.parseColor("#940418")))
                    }
                    HintCounter.text = ("Hint : ${hintRemainding-1}/3")
                    hintRemainding-=1
                }
                else
                    Toast.makeText(this,"No hint left",Toast.LENGTH_SHORT).show()


            }

            


        }






    }

}