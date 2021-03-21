package com.otnieldocs.googletemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Firebase.remoteConfig.fetchAndActivate().addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val updated = task.result
                Log.d("MAIN_ACTIVITY", "Config params updated: $updated")
            } else {
                Log.d("MAIN_ACTIVITY", "Fetch failed")
            }

            val tv = findViewById<TextView>(R.id.simple_textview)
            tv.text = Firebase.remoteConfig.getString("app_main_enabled")
        }

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