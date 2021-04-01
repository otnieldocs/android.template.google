package com.otnieldocs.googletemplate

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.otnieldocs.googletemplate.config.DeepLinkCfg

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DeepLinkCfg.build(intent?.data)

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
    }
}