package com.example.graduation2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkbtn.setOnClickListener{
            val intent = Intent(this, Inputnum::class.java)
            startActivity(intent)
        }
        addcarbtn.setOnClickListener{
            val intent = Intent(this, Inputnum::class.java)
            startActivity(intent)
        }

        listbtn.setOnClickListener{
            val intent = Intent(this, Inputnum::class.java)
            startActivity(intent)
        }
    }
}