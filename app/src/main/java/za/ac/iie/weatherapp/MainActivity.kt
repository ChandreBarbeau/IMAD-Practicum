package za.ac.iie.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Declare and initialize variables
        val btnMainMenu:Button= findViewById(R.id.btnMainMenu)
        btnMainMenu.setOnClickListener {
            val intent=Intent(this,MainMenu::class.java)
            startActivity(intent)

        }

        val btnExit:Button=findViewById(R.id.btnExit)
        btnExit.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            System.exit(0)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}