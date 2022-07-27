package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

//    private lateinit var textView : TextView
//    private lateinit var imageView: ImageView

//    private lateinit var  tourList : ArrayList<Tour>
//    private var position by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        val tour = tourList[position]
        val detail = intent.getParcelableExtra<Tour>("tour")
        if(detail != null) {
            val imageView : ImageView = findViewById(R.id.detail_image)
            val textView : TextView = findViewById(R.id.detail_text)
            textView.text = detail.name
            imageView.setImageResource(detail.image)
        }
    val back = findViewById<ImageView>(R.id.back_arrow1)
    back.setOnClickListener {
        Toast.makeText(this, "back ..", Toast.LENGTH_SHORT).show()
        //->setContentView(R.layout.activity_main)
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
    }
}