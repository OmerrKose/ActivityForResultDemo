package com.example.activityforresultdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        buttonFinish.setOnClickListener{
            // Set the result code OK to make sure that button is pressed
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}