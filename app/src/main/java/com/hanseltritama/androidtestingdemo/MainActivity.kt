package com.hanseltritama.androidtestingdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(v: View) {
        textResult.text = "Welcome, ${firstName.text} ${lastName.text}!"
    }

    fun onNextActivityClick(v: View) {
        val intent = Intent(this, OtherActivity::class.java)
        intent.putExtra("firstNameKey", firstName.text.toString())
        intent.putExtra("lastNameKey", lastName.text.toString())
        startActivity(intent)
    }
}