package za.ac.iie.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViews : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_views)
        //Declare variables

        val btnMainmenu:Button = findViewById(R.id.btnMainmenu)
        val Details = findViewById<TextView>(R.id.Details)
        val txtDay = intent.getStringExtra("display_Day_")
        Details.text = txtDay


        //Initialize button

        btnMainmenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}



