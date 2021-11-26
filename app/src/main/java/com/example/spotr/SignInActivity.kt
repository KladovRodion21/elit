package com.example.spotr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
import java.util.regex.Pattern.compile

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
        if(email.text.isNotEmpty() && password.text.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches())
        {
            val retrofit =MyRetrofit().getRetrofit().create(RetApi::class.java)
            val hashMap: HashMap<String, String> = HashMap()
            hashMap["email"] = email.text.toString()
            hashMap["password"] = password.text.toString()
            val call: Call<Login> = retrofit.login(hashMap)
            call.enqueue((object: retrofit2.Callback<Login>{
                override fun OnResponse(call: Call<Login>, response: Response<Login>){
                    if (response.body()?.token!=null){
                        Login.userToken = response.body()?.token
                        Toast.makeText(this@SignInActivity,"Успешно", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@SignInActivity,MainActivity::class.java))
                        finish()
                    }
                    else{

                    }
                }
            }))
            startActivity(Intent(this@SignInActivity, MainActivity::class.java))

        }
        else AlertDialog.Builder(this@SignInActivity).setMessage("Неверные данные входа").show()




    }
}