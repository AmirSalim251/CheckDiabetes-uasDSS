package com.example.checkdiabetes

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class ActTransk : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transkrip)


        val nama = intent.getStringExtra("nama")
        var umur = intent.getStringExtra("umur")
        val jk = intent.getStringExtra("JenisKelamin")
        val hipert = intent.getStringExtra("Hipertensi")
        val heartD = intent.getStringExtra("HeartD")
        val hb = intent.getStringExtra("Hb")
        val gluk = intent.getStringExtra("Glukosa")
        val smoke = intent.getStringExtra("Smoked")
        val bmi = intent.getStringExtra("Bmi")
        val dec = intent.getStringExtra("Keputusan")

        findViewById<TextView>(R.id.namaH_tview).text = nama
        findViewById<TextView>(R.id.umurH_tview).text = umur
        findViewById<TextView>(R.id.jkH_tview).text = jk
        findViewById<TextView>(R.id.hipertH_tview).text = hipert
        findViewById<TextView>(R.id.heartH_tview).text = heartD
        findViewById<TextView>(R.id.hbH_tview).text = hb
        findViewById<TextView>(R.id.glukH_tview).text = gluk
        findViewById<TextView>(R.id.smokeH_tview).text = smoke
        findViewById<TextView>(R.id.bmiH_tview).text = bmi
        findViewById<TextView>(R.id.dec_tview).text = dec

        val re_button = findViewById<Button>(R.id.repeat_button3)
        re_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val bck_button = findViewById<Button>(R.id.backk_button)
        bck_button.setOnClickListener{
            val intentB = Intent(this, AkhirActivity::class.java)

            intentB.putExtra("nama",intent.getStringExtra("nama"))
            intentB.putExtra("umur",intent.getStringExtra("umur"))
            intentB.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intentB.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intentB.putExtra("HeartD",intent.getStringExtra("HeartD"))
            intentB.putExtra("Smoked",intent.getStringExtra("Smoked"))
            intentB.putExtra("Hb",intent.getStringExtra("Hb"))
            intentB.putExtra("Glukosa",intent.getStringExtra("Glukosa"))
            intentB.putExtra("Bmi",intent.getStringExtra("Glukosa"))

            startActivity(intentB)
            overridePendingTransition(0,0)
        }










    }
}