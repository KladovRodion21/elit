package com.example.spotr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.spotr.db.Login
import com.example.spotr.db.MyRetrofit
import com.example.spotr.db.RetApi
import retrofit2.Call
import retrofit2.Response

class RegActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var repeatpass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        password = findViewById(R.id.editTextTextPasswordReg)
        email = findViewById(R.id.editTextTextEmailAddressReg)
        repeatpass = findViewById(R.id.editTextTextPasswordRegRepeat)
        name = findViewById(R.id.editTextTextPersonName)
    }


        fun regi(view: View) {
            if (email.text.isNotEmpty() && name.text.isNotEmpty()  && password.text.isNotEmpty() && repeatpass.text.isNotEmpty()) {
                if (password.text.toString() == repeatpass.text.toString()) {
                    val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
                    val hashMap: HashMap<String, String> = HashMap<String, String>()
                    hashMap["email"] = email.text.toString()
                    hashMap["password"] = password.text.toString()
                    hashMap["firstName"] = name.text.toString()
                    val call: Call<Void> = retrofit.registration(hashMap)
                    call.enqueue(object : retrofit2.Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            Toast.makeText(
                                this@RegActivity,
                                "Успешная регистрация",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            val toast =
                                Toast.makeText(this@RegActivity, t.message, Toast.LENGTH_SHORT)
                                    .show()
                        }
                    })
                } else {
                    val alert = AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Заполните все поля")
                        .setPositiveButton("OK", null)
                        .create()
                        .show()
                }





            }
            else{
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Заполните все поля")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }
        }
    fun cancel(view: android.view.View) { finish() }
    }




