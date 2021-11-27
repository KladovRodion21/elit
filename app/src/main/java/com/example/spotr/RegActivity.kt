package com.example.spotr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Response

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
    fun registrations (view:android.view.View) {
        if (email.text.isNotEmpty() && password.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches() ) {
            Toast.makeText(this, "Успешная регистрация",Toast.LENGTH_SHORT).show()

        }
        else{

            val alert = AlertDialog.Builder(this,)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("ОК",null)
                .create()
                .show()
        }
    }
}
