package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class Activity2:ComponentActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_2)

        val back_button= findViewById<Button>(R.id.back_button)
        back_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button2 = findViewById<Button>(R.id.cont_button2)

        cont_button2.setOnClickListener{
            val intent2 = Intent(this, Activity3::class.java)

            intent2.putExtra("nama",intent.getStringExtra("nama"))
            intent2.putExtra("umur",findViewById<EditText>(R.id.umur_tfield).text.toString())

            startActivity(intent2)
            overridePendingTransition(0,0)
        }


    }

}