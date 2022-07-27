package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userName = findViewById<EditText>(R.id.name)
        val password = findViewById<EditText>(R.id.Password)
        val login = findViewById<Button>(R.id.submit)
        val forget = findViewById<TextView>(R.id.forget)
        login.setOnClickListener{
            val uName = userName.text.toString()
            val pass = password.text.toString()
            if(uName=="" || pass=="") {
                Toast.makeText(this, "Please,Check Name or Password..", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this,"Successfully Login..",Toast.LENGTH_SHORT).show()
                userName.text.clear()
                password.text.clear()
                // setContentView(R.layout.second_activity)
                val intent = Intent(this,SecondActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE,uName)
                }
                startActivity(intent)
            }
        }
        forget.setOnClickListener{
            setContentView(R.layout.forget_activity)
        }
    }
}