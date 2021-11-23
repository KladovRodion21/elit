package com.example.spotr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        val timer = object: CountDownTimer(1000,100)
        {

            override fun onTick(p0: Long)
            {

            }

            override fun onFinish()
            {
                val intent = Intent(this@LoadingActivity, GuideActivity:: class.java)
                startActivity(intent)
            }

        }
        timer.start()

    }

    }
