package com.hanseltritama.androidtestingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val firstName = intent.getStringExtra("firstNameKey")
        val lastName = intent.getStringExtra("lastNameKey")

        textConfirmation.text = "Your name is $firstName $lastName"
    }
}