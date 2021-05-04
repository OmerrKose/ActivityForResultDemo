package com.example.activityforresultdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonSubmit.setOnClickListener{
            // Create an instance to return the data to the main activity
            val intent = Intent()

            // Return the data entered by the user to the main activity
            intent.putExtra(MainActivity.NAME, name.text.toString())
            intent.putExtra(MainActivity.NAME, email.text.toString())

            // Set the result code OK to make sure that button is pressed
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}