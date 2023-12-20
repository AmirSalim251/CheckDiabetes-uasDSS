package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.ComponentActivity

class Activity5 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_4)

        val dropdown = findViewById<Spinner>(R.id.heartd_dropdown)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.tf_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dropdown.adapter = adapter
        }

        val back_button = findViewById<Button>(R.id.back_button3)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button = findViewById<Button>(R.id.cont_button4)

        cont_button.setOnClickListener{
            val intent5 = Intent(this, Activity6::class.java)

            intent5.putExtra("nama",intent.getStringExtra("nama"))
            intent5.putExtra("umur",intent.getStringExtra("umur"))
            intent5.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intent5.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intent5.putExtra("HeartD",findViewById<Spinner>(R.id.heartd_dropdown).selectedItem.toString())


            startActivity(intent5)
            overridePendingTransition(0,0)
        }


    }
}