package com.example.checkdiabetes

import android.os.Bundle
import android.view.View
import android.content.Intent
import android.text.Editable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.checkdiabetes.ui.theme.CheckDiabetesTheme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : ComponentActivity() {
    public var hasil_tview: String = "TEST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_1)
        var cont_buton = findViewById<Button>(R.id.cont_button)

        cont_buton.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)

            intent.putExtra("nama",findViewById<EditText>(R.id.nama_tfield).text.toString())

            startActivity(intent)
            overridePendingTransition(0,0)






        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CheckDiabetesTheme {
        Greeting("Android")
    }
}