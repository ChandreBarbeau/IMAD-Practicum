package za.ac.iie.weatherapp

import android.content.Intent
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        //Declare variables
        val daydeets = findViewById<TextView>(R.id.daydeets)
        val MinTemp = findViewById<TextView>(R.id.Mindeets)
        val MaxTemp = findViewById<TextView>(R.id.Maxdeets)
        val WeatherCondition = findViewById<TextView>(R.id.conditions)


        //Initialize variables
        var i: Int = 0//stores numbers
        var Day: String = "" // Display blank first
        var maxEntries = 9// Only allow 9 array entries

        var TxtMin: Int = 0
        var txtMax: Int = 0
        var txtCondition: String = ""


        // Arrays
        val day = Array(maxEntries) { "" }
        val Mindeets = Array(maxEntries) { 0 }
        val Maxdeets = Array(maxEntries) { 0 }
        val Conditiondeets = Array(maxEntries) { "" }

        val btnExit: Button = findViewById(R.id.btnExit)
        val BtnDetails: Button = findViewById(R.id.btnDetails)
        val btnClear: Button = findViewById(R.id.btnClear)
        BtnDetails.setOnClickListener {
            // Check if there's enough entries
            if (i < maxEntries) {
                //Convert to display types
                day[i] = daydeets.text.toString()
                // Mindeets.contentToString().toIntOrNull().?:.also { Mindeets[i] = it } 0//0 is for error checking
                Maxdeets[i] =
                    Maxdeets.contentToString().toIntOrNull() ?: 0
                Conditiondeets[i] = Conditiondeets.contentToString()
                i++//increment entry number

                Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No.Entries reached Maximum", Toast.LENGTH_SHORT).show()

                val BtnDetails: Button = findViewById(R.id.btnDetails)
                BtnDetails.setOnClickListener {
                    val intent = Intent(this, DetailedViews::class.java)
                    startActivity(intent)


                }

                // Clear the Text Views
                btnClear.setOnClickListener {
                    daydeets.text = ""

                    i = 0 //reset entry number
                    Toast.makeText(this, "EntriesCleared", Toast.LENGTH_SHORT).show()


                }
            } // Pass the data to DetailsViewActivity and start the activity
            val  intent= Intent(this,DetailedViews::class.java)
            intent.putExtra("Display_Data",display)
            startActivity(intent)



        }


        }


    }
}