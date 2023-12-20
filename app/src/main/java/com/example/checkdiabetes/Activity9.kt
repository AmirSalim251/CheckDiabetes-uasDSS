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

class Activity9 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_8)

        val back_button = findViewById<Button>(R.id.back_button7)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity8::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button = findViewById<Button>(R.id.cont_button10)

        cont_button.setOnClickListener{
            val intent9 = Intent(this, AkhirActivity::class.java)
            intent9.putExtra("nama",intent.getStringExtra("nama"))
            intent9.putExtra("umur",intent.getStringExtra("umur"))
            intent9.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intent9.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intent9.putExtra("HeartD",intent.getStringExtra("HeartD"))
            intent9.putExtra("Smoked",intent.getStringExtra("Smoked"))
            intent9.putExtra("Hb",intent.getStringExtra("Hb"))
            intent9.putExtra("Glukosa",intent.getStringExtra("Glukosa"))
            intent9.putExtra("Bmi",findViewById<EditText>(R.id.bmi_tfield).text.toString())




            startActivity(intent9)
            overridePendingTransition(0,0)
        }


    }
}