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

class Activity7 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_6)

        val back_button = findViewById<Button>(R.id.back_button5)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity6::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button = findViewById<Button>(R.id.cont_button6)

        cont_button.setOnClickListener{
            val intent7 = Intent(this, Activity8::class.java)

            intent7.putExtra("nama",intent.getStringExtra("nama"))
            intent7.putExtra("umur",intent.getStringExtra("umur"))
            intent7.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intent7.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intent7.putExtra("HeartD",intent.getStringExtra("HeartD"))
            intent7.putExtra("Smoked",intent.getStringExtra("Smoked"))
            intent7.putExtra("Hb",findViewById<EditText>(R.id.hba1c_tfield).text.toString())

            startActivity(intent7)
            overridePendingTransition(0,0)
        }


    }
}