package com.otnieldocs.googletemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // turn on this section when you want to make a runtime crash to test the crashlytics
//        val crashButton = Button(this)
//        crashButton.text = "Crash!"
//        crashButton.setOnClickListener {
//            throw RuntimeException("Test Crash") // Force a crash
//        }
//
//        addContentView(crashButton, ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT))
    }
}