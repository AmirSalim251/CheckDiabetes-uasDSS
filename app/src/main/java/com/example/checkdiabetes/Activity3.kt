package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity



class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_1jk)
        val jk_dropdown = findViewById<Spinner>(R.id.jk_dropdown)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.jk_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            jk_dropdown.adapter = adapter
        }
        val back_button = findViewById<Button>(R.id.back_button8)
        back_button.setOnClickListener{
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val cont_button2 = findViewById<Button>(R.id.cont_button8)

        cont_button2.setOnClickListener{
            val intent3 = Intent(this, Activity4::class.java)


            intent3.putExtra("nama",intent.getStringExtra("nama"))
            intent3.putExtra("umur",intent.getStringExtra("umur"))
            intent3.putExtra("JenisKelamin",findViewById<Spinner>(R.id.jk_dropdown).selectedItem.toString())



            startActivity(intent3)
            overridePendingTransition(0,0)
        }




    }


}