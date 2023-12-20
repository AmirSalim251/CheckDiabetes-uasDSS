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


class AkhirActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hasil)


        val nama = intent.getStringExtra("nama")
        var umur = intent.getStringExtra("umur")
        val jk = intent.getStringExtra("JenisKelamin")
        val hipert = intent.getStringExtra("Hipertensi")
        val heartD = intent.getStringExtra("HeartD")
        val hb = intent.getStringExtra("Hb")
        val gluk = intent.getStringExtra("Glukosa")
        val smoke = intent.getStringExtra("Smoked")
        val bmi = intent.getStringExtra("Bmi")

        // Mengkonversikan nilai string pilihan menjadi angka (Female = 1 dan Male = 0)
        fun convertGenderString(x:String):Int{
            var hasil : Int = 0
            if(x == "Female" || x =="Perempuan"){
                hasil =  1
            }
            return hasil
        }

        // Mengkonversikan nilai string pilihan menjadi angka (Pernah Hipertensi = 1 dan Tidak pernah hipertensi = 0)
        fun convertHipertString(x:String):Int{
            var hasil : Int = 0
            if(x == "Pernah"){
                hasil =  1
            }
            return hasil
        }

        // Mengkonversikan nilai string pilihan menjadi angka (Pernah ada penyakit jantung = 1 dan Tidak pernah penyakit jantung = 0)
        fun convertHeartDString(x:String):Int{
            var hasil : Int = 0
            if(x == "Pernah"){
                hasil =  1
            }
            return hasil
        }

        // Mengkonversikan nilai string pilihan menjadi angka (Tidak pernah merokok= 0 , Masih perokok = 1 , Mantan perokok = 2)
        fun convertSmokeString(x:String):Int{
            var hasil : Int = 0
            if(x == "Masih perokok" || x == "current"){
                hasil = 1
            }

            else if(x == "Mantan perokok" || x == "former"){
                hasil =  2
            }
            return hasil
        }

        // Memmbuat array data berdasarkan data historis penyakit diabetes (https://www.kaggle.com/datasets/iammustafatz/diabetes-prediction-dataset/data)
        // Mengambil 100 data, dimana 60 data histori orang tidak terkena diabetes, dan 40 data histori orang terkena diabetes
        // Index [i][0] = Jenis Kelamin
        // Index [i][1] = Umur
        // Index [i][2] = Apakah ada histori hipertensi (0 : iya dan 1 : tidak)
        // Index [i][3] = Apakah ada histori penyakit jantung (0 : iya dan 1 : tidak)
        // Index [i][4] = Apakah ada histori merokok
        // Index [i][5] = Body Mass index
        // Index [i][6] = Level HbA1c
        // Index [i][7] = Kadar gula darah
        // Index [i][8] = Apakah terkena diabetes (0 : iya dan 1 : tidak)
        var arrayData = arrayOf(
            arrayOf("Female","44.0","0","0","never","19.31","6.5","200","1"),
            arrayOf("Male","67.0","0","1","not current","27.32","6.5","200","1"),
            arrayOf("Male","50.0","1","0","current","27.32","5.7","260","1"),
            arrayOf("Male","73.0","0","0","former","25.91","9.0","160","1"),
            arrayOf("Female","53.0","0","0","former","27.32","7.0","159","1"),
            arrayOf("Male","50.0","0","0","former","37.16","9.0","159","1"),
            arrayOf("Female","67.0","0","0","never","63.48","8.8","155","1"),
            arrayOf("Male","57.0","0","0","NoInfo","27.32","8.2","126","1"),
            arrayOf("Female","36.0","0","0","current","32.27","6.2","220","1"),
            arrayOf("Female","60.0","0","0","never","27.32","7.5","300","1"),
            arrayOf("Female","67.0","0","0","never","27.32","6.2","159","1"),
            arrayOf("Female","80.0","1","0","never","27.32","6.8","280","1"),
            arrayOf("Female","77.0","0","0","never","31.7","6.5","280","1"),
            arrayOf("Male","80.0","0","0","never","22.06","9.0","155","1"),
            arrayOf("Female","47.0","0","0","never","36.49","7.5","155","1"),
            arrayOf("Female","80.0","0","0","former","21.97","7.0","300","1"),
            arrayOf("Male","53.0","0","0","current","30.8","6.6","280","1"),
            arrayOf("Female","61.0","0","0","not current","39.36","9.0","140","1"),
            arrayOf("Male","76.0","0","0","never","31.9","7.5","155","1"),
            arrayOf("Female","43.0","0","0","never","26.71","6.5","300","1"),
            arrayOf("Male","55.0","0","0","NoInfo","27.32","6.8","159","1"),
            arrayOf("Male","57.0","1","1","not current","27.77","6.6","160","1"),
            arrayOf("Female","64.0","0","0","never","27.32","6.2","155","1"),
            arrayOf("Male","63.0","1","0","ever","35.06","5.8","200","1"),
            arrayOf("Male","80.0","0","0","never","23.25","6.1","159","1"),
            arrayOf("Female","70.0","0","0","current","29.25","8.2","130","1"),
            arrayOf("Female","48.0","0","0","never","20.19","7.0","145","1"),
            arrayOf("Female","42.0","0","0","never","24.81","9.0","159","1"),
            arrayOf("Female","80.0","0","0","former","36.18","6.5","200","1"),
            arrayOf("Female","52.0","1","0","never","50.3","6.6","155","1"),
            arrayOf("Male","71.0","0","0","never","27.09","8.2","200","1"),
            arrayOf("Male","80.0","0","1","former","24.36","7.5","280","1"),
            arrayOf("Male","59.0","0","0","current","29.2","8.2","220","1"),
            arrayOf("Male","29.0","0","0","current","25.41","6.1","130","1"),
            arrayOf("Female","68.0","0","0","NoInfo","40.31","7.5","260","1"),
            arrayOf("Female","52.0","0","0","NoInfo","27.32","9.0","140","1"),
            arrayOf("Female","70.0","0","0","not current","33.19","7.5","126","1"),
            arrayOf("Male","71.0","0","0","never","26.53","8.8","159","1"),
            arrayOf("Male","48.0","1","0","current","36.12","6.8","140","1"),
            arrayOf("Female","79.0","1","0","former","27.32","6.5","159","1"),
            arrayOf("Female","80.0","0","1","never","25.19","6.6","140","0"),
            arrayOf("Female","54.0","0","0","NoInfo","27.32","6.6","80","0"),
            arrayOf("Male","28.0","0","0","never","27.32","5.7","158","0"),
            arrayOf("Female","36.0","0","0","current","23.45","5.0","155","0"),
            arrayOf("Male","76.0","1","1","current","20.14","4.8","155","0"),
            arrayOf("Female","20.0","0","0","never","27.32","6.6","85","0"),
            arrayOf("Female","79.0","0","0","NoInfo","23.86","5.7","85","0"),
            arrayOf("Male","42.0","0","0","never","33.64","4.8","145","0"),
            arrayOf("Female","32.0","0","0","never","27.32","5.0","100","0"),
            arrayOf("Female","53.0","0","0","never","27.32","6.1","85","0"),
            arrayOf("Female","54.0","0","0","former","54.7","6.0","100","0"),
            arrayOf("Female","78.0","0","0","former","36.05","5.0","130","0"),
            arrayOf("Female","67.0","0","0","never","25.69","5.8","200","0"),
            arrayOf("Female","76.0","0","0","NoInfo","27.32","5.0","160","0"),
            arrayOf("Male","78.0","0","0","NoInfo","27.32","6.6","126","0"),
            arrayOf("Male","15.0","0","0","never","30.36","6.1","200","0"),
            arrayOf("Female","42.0","0","0","never","24.48","5.7","158","0"),
            arrayOf("Female","42.0","0","0","NoInfo","27.32","5.7","80","0"),
            arrayOf("Male","37.0","0","0","ever","25.72","3.5","159","0"),
            arrayOf("Male","40.0","0","0","current","36.38","6.0","90","0"),
            arrayOf("Male","5.0","0","0","NoInfo","18.8","6.2","85","0"),
            arrayOf("Female","69.0","0","0","never","21.24","4.8","85","0"),
            arrayOf("Female","72.0","0","1","former","27.94","6.5","130","0"),
            arrayOf("Female","4.0","0","0","NoInfo","13.99","4.0","140","0"),
            arrayOf("Male","30.0","0","0","never","33.76","6.1","126","0"),
            arrayOf("Male","40.0","0","0","former","27.85","5.8","80","0"),
            arrayOf("Male","45.0","1","0","never","26.47","4.0","158","0"),
            arrayOf("Male","43.0","0","0","never","26.08","6.1","155","0"),
            arrayOf("Female","53.0","0","0","NoInfo","31.75","4.0","200","0"),
            arrayOf("Male","50.0","0","0","NoInfo","25.15","4.0","145","0"),
            arrayOf("Female","41.0","0","0","current","22.01","6.2","126","0"),
            arrayOf("Female","20.0","0","0","never","22.19","3.5","100","0"),
            arrayOf("Female","76.0","0","0","never","23.55","5.0","85","0"),
            arrayOf("Male","5.0","0","0","NoInfo","15.1","5.8","85","0"),
            arrayOf("Female","15.0","0","0","NoInfo","21.76","4.5","130","0"),
            arrayOf("Female","26.0","0","0","never","21.22","6.6","200","0"),
            arrayOf("Female","34.0","0","0","never","56.43","6.2","200","0"),
            arrayOf("Male","5.0","0","0","NoInfo","27.32","6.6","130","0"),
            arrayOf("Female","77.0","1","1","never","32.02","5.0","159","0"),
            arrayOf("Female","66.0","0","0","NoInfo","29.3","4.8","159","0"),
            arrayOf("Female","67.0","0","0","NoInfo","27.32","3.5","160","0"),
            arrayOf("Female","44.0","0","0","never","24.93","6.1","100","0"),
            arrayOf("Female","29.0","0","0","never","19.95","5.0","90","0"),
            arrayOf("Female","60.0","0","0","never","18.03","4.0","159","0"),
            arrayOf("Female","38.0","0","0","never","28.27","6.2","155","0"),
            arrayOf("Female","3.0","0","0","NoInfo","19.27","6.5","100","0"),
            arrayOf("Male","57.0","0","0","never","27.32","6.1","155","0"),
            arrayOf("Female","26.0","0","0","NoInfo","27.32","4.0","200","0"),
            arrayOf("Female","74.0","0","0","NoInfo","28.12","5.0","100","0"),
            arrayOf("Female","45.0","1","0","never","23.05","4.8","130","0"),
            arrayOf("Male","30.0","0","0","NoInfo","27.32","6.6","140","0"),
            arrayOf("Female","19.0","0","0","never","23.35","3.5","155","0"),
            arrayOf("Male","46.0","0","0","NoInfo","24.41","5.0","140","0"),
            arrayOf("Male","44.0","1","0","current","27.86","6.6","145","0"),
            arrayOf("Female","21.0","0","0","not current","26.1","5.8","140","0"),
            arrayOf("Female","30.0","0","0","current","27.32","6.5","158","0"),
            arrayOf("Female","59.0","0","0","former","27.32","6.0","159","0"),
            arrayOf("Female","27.0","0","0","not current","30.22","5.7","100","0"),
            arrayOf("Female","59.0","0","1","ever","23.11","6.5","200","0"),
            arrayOf("Female","19.0","0","0","not current","27.32","5.7","145","0")
        )

        // Specify the size of the 2D array
        val rows = 100
        val cols = 2

        // Initialize a 2D array of strings
        val arrayOfFloat = Array(rows) { Array(cols) { 0f } }

        var i = 0
        var j =0

        // Perhitungan kuadrat untuk query instance
        while(i<100){
                var jkPow = convertGenderString(arrayData[i][0]) - convertGenderString(jk.toString())
                var umurFPow = arrayData[i][1].toFloat()  - umur.toString().toFloat()
                var hipertPow = convertHipertString(arrayData[i][2]) - convertHipertString(hipert.toString())
                var heartDPow = convertHeartDString(arrayData[i][3]) - convertHeartDString(heartD.toString())
                var smokePow = convertSmokeString(arrayData[i][4]) - convertSmokeString(smoke.toString())
                var bmiPow = arrayData[i][5].toFloat()  - bmi.toString().toFloat()
                var hBPow = arrayData[i][6].toFloat()  - hb.toString().toFloat()
                var gluK= arrayData[i][7].toFloat() - gluk.toString().toFloat()

                arrayOfFloat[i][0] = (jkPow*jkPow) + (umurFPow*umurFPow) + (hipertPow*hipertPow) + (heartDPow*heartDPow) + (smokePow*smokePow) +  (bmiPow*bmiPow) +  (hBPow*hBPow) + (gluK*gluK)
                arrayOfFloat[i][1] = arrayData[i][8].toFloat()

            i+=1
        }
        i = 0

        // Melakukan sorting berdasarkan perhitungan query instance
        val sortedArray = arrayOfFloat.sortedBy { it[0] }

        var diab = 0
        var noDiab = 0
        var hasilAkhir = ""

        // Mencari tetangga terdekat dengan k = 5 dan di cek tetangga terdekat nilai kediabetesannya ya atau tidak
        while(i<5){

            if(sortedArray[i][1] == 0f){
                noDiab+=1
            }
            else{
                diab+=1
            }
            i+=1
        }

        if(noDiab>diab){
            hasilAkhir = "Tidak beresiko dibates"
        }
        else{
            hasilAkhir = "Beresiko diabetes"
        }

        findViewById<TextView>(R.id.hasil_tview).text = hasilAkhir


        val re_button = findViewById<Button>(R.id.repeat_button)
        re_button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        val transk_button = findViewById<Button>(R.id.transk_button)
        transk_button.setOnClickListener{
            val intentA = Intent(this, ActTransk::class.java)
            intentA.putExtra("nama",intent.getStringExtra("nama"))
            intentA.putExtra("umur",intent.getStringExtra("umur"))
            intentA.putExtra("JenisKelamin",intent.getStringExtra("JenisKelamin"))
            intentA.putExtra("Hipertensi",intent.getStringExtra("Hipertensi"))
            intentA.putExtra("HeartD",intent.getStringExtra("HeartD"))
            intentA.putExtra("Smoked",intent.getStringExtra("Smoked"))
            intentA.putExtra("Hb",intent.getStringExtra("Hb"))
            intentA.putExtra("Glukosa",intent.getStringExtra("Glukosa"))
            intentA.putExtra("Bmi",intent.getStringExtra("Glukosa"))
            intentA.putExtra("Keputusan",hasilAkhir)


            startActivity(intentA)
            overridePendingTransition(0,0)
        }



    }

}