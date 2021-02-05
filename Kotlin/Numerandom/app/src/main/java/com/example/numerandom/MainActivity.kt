package com.example.numerandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val random = java.util.Random();
            var randomNum = random.nextInt(seekBar.progress + 1)
            randomText.visibility = View.VISIBLE
            randomText.text = randomNum.toString()
        }
    }
}