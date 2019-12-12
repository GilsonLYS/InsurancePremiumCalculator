package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var myData: MyDataModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonCalculate.setOnClickListener(){
            try {
                val age = spinnerAge.selectedItemPosition
                val female = radioButtonFemale.isChecked
                val male = radioButtonFemale.isChecked
                var total = 0

                when{
                    age == 0 -> {total += 60}

                    age == 1 ->
                        if (!checkBoxSmoker.isChecked){
                            total += 70
                        }else if(female && checkBoxSmoker.isChecked){
                            total += 70 + 100
                        }else {
                            total += 70 + 100 + 50
                        }
                    age == 2 ->
                        if (!checkBoxSmoker.isChecked){
                            total += 90
                        }else if(female && checkBoxSmoker.isChecked){
                            total += 90 + 150
                        }else {
                            total += 90 + 150 + 100
                        }
                    age == 3 ->
                        if (!checkBoxSmoker.isChecked){
                            total += 120
                        }else if(female && checkBoxSmoker.isChecked){
                            total += 120 + 200
                        }else {
                            total += 120 + 200 + 150
                        }
                    age == 4 ->
                        if (!checkBoxSmoker.isChecked){
                            total += 150
                        }else if(female && checkBoxSmoker.isChecked){
                            total += 150 + 250
                        }else {
                            total += 150 + 250 + 200
                        }
                    age == 5 ->
                        if (!checkBoxSmoker.isChecked){
                            total += 150
                        }else if(female && checkBoxSmoker.isChecked){
                            total += 150 + 300
                        }else {
                            total += 150 + 300 + 200
                        }
                }
                textViewPremium.text = "Total Premium Cost: RM" + total

            }catch (ex:Exception){
                val toast:Toast = Toast.makeText(applicationContext, "Don't leave Blank!!",Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }

        }

        buttonReset.setOnClickListener(){
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.setChecked(false)

        }

    }

    

}
