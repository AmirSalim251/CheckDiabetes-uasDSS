package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.ComponentActivity

class Activity4 : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_3)

        val dropdown = findViewById<Spinner>(R.id.hipert_dropdown)
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

        val back_button = findViewById<Button>(R.id.back_button2)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button = findViewById<Button>(R.id.cont_button3)

        cont_button.setOnClickListener{
            val intent4 = Intent(this, Activity5::class.java)

            intent4.putExtra("nama",intent.getStringExtra("nama"))
            intent4.putExtra("umur",intent.getStringExtra("umur"))
            intent4.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intent4.putExtra("Hipertensi",findViewById<Spinner>(R.id.hipert_dropdown).selectedItem.toString())


            startActivity(intent4)
            overridePendingTransition(0,0)
        }


    }
}