package com.example.spotr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class RegActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var repeatpass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        password= findViewById(R.id.editTextTextpassreg)
        email= findViewById(R.id.editTextTextEmailAddressReg)
        repeatpass= findViewById(R.id.editTextTextRepeatpass)
    }
    fun registrations (view:android.view.View){
        if(email.text.isNotEmpty() && password.text.isNotEmpty()&&repeatpass.text.isNotEmpty()&&repeatpass==password && Patterns.EMAIL_ADDRESS.matcher(email.text).matches())
        {
            startActivity(Intent(this@RegActivity, SignInActivity::class.java))

        }
        else AlertDialog.Builder(this@RegActivity).setMessage("Неверные данные регистрации").show()
    }
    fun back(view:android.view.View){
        startActivity(Intent(this@RegActivity, SignInActivity::class.java))
    }
}