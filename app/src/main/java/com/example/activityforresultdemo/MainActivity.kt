package com.example.activityforresultdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        // Variables used to pass the data to the other activities
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        // Default variables for the data
        const val NAME = "name"
        const val EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // First Activity Button
        buttonFirstActivity.setOnClickListener {
            // Create an intent to retrieve the data from the first activity
            val intent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivityForResult(
                intent,
                FIRST_ACTIVITY_REQUEST_CODE
            )
        }

        // Second Activity Button
        buttonSecondActivity.setOnClickListener {
            // Create an intent to retrieve the data from the second activity
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(
                intent,
                SECOND_ACTIVITY_REQUEST_CODE
            )
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            // If request made with the first activity code...
            if (requestCode == FIRST_ACTIVITY_REQUEST_CODE) {
                tvFirstActivityResult.text = getString(R.string.firstActivityResultText)
            }
            // If the request made with the second activity code...
            else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
                if (data != null) {
                    // Pull the data entered by the user from the second activity
                    val name = data.getStringExtra(NAME)
                    val email = data.getStringExtra(EMAIL)
                    tvSecondActivityResult.text = "$name => $email"
                }
            }
        }
        // If user doesn't press the buttons...
        else if (resultCode == RESULT_CANCELED) {
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(
                this@MainActivity,
                "Result Cancelled",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}