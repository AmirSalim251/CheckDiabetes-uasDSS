package com.example.checkdiabetes


import android.content.Intent
import android.os.Handler
import android.view.WindowManager
import android.os.Bundle
import android.os.Looper
import android.os.PersistableBundle
import androidx.activity.ComponentActivity

class SplashScreen:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        //Normal Handler is deprecated , so we have to change the code little bit

        // Handler().postDelayed({
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }

}