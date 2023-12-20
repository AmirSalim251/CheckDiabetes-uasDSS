package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity

class Activity8 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_7)

        val back_button = findViewById<Button>(R.id.back_button6)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity7::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button = findViewById<Button>(R.id.cont_button7)

        cont_button.setOnClickListener{
            val intent8 = Intent(this, Activity9::class.java)
            intent8.putExtra("nama",intent.getStringExtra("nama"))
            intent8.putExtra("umur",intent.getStringExtra("umur"))
            intent8.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intent8.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intent8.putExtra("HeartD",intent.getStringExtra("HeartD"))
            intent8.putExtra("Smoked",intent.getStringExtra("Smoked"))
            intent8.putExtra("Hb",intent.getStringExtra("Hb"))
            intent8.putExtra("Glukosa",findViewById<EditText>(R.id.glucose_tfield).text.toString())




            startActivity(intent8)
            overridePendingTransition(0,0)
        }


    }
}