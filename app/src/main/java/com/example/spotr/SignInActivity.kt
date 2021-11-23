package com.example.spotr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class SignInActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        password= findViewById(R.id.editTextTextPassword)
        email= findViewById(R.id.editTextTextEmailAddress)


    }
    fun reg(view:android.view.View)
    {
        startActivity(Intent(this@SignInActivity, RegActivity::class.java))
    }


    fun Login (view:android.view.View){
        if(email.text.isNotEmpty() && password.text.isNotEmpty())
        {
            startActivity(Intent(this@SignInActivity, MainActivity::class.java))

        }
        else AlertDialog.Builder(this@SignInActivity).setMessage("Неверные данные входа").show()




    }
}