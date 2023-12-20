package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.ComponentActivity

class Activity6 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_5)

        val dropdown = findViewById<Spinner>(R.id.smoked_dropdown)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.smoke_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dropdown.adapter = adapter
        }

        val back_button = findViewById<Button>(R.id.back_button4)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity5::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button = findViewById<Button>(R.id.cont_button5)

        cont_button.setOnClickListener{
            val intent6 = Intent(this, Activity7::class.java)

            intent6.putExtra("nama",intent.getStringExtra("nama"))
            intent6.putExtra("umur",intent.getStringExtra("umur"))
            intent6.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intent6.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intent6.putExtra("HeartD",intent.getStringExtra("HeartD"))
            intent6.putExtra("Smoked",findViewById<Spinner>(R.id.smoked_dropdown).selectedItem.toString())


            startActivity(intent6)
            overridePendingTransition(0,0)
        }


    }
}