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
import com.example.spotr.RetApi
import com.example.spotr.MyRetrofit



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
           val retrofit = MyRetrofit().getRetrofit().create(RetApi::class.java)
            val log = MyRetrofit().getRetrofit()
            val getApi=log.create(RetApi::class.java)
            var hashMap: HashMap<String,String> = HashMap <String, String>()
            hashMap.put("email" , email.text.toString())
            hashMap.put("password" , password.text.toString())
            val log_call: retrofit2.Call<Login> = getApi.login(hashMap)

            log_call.enqueue(object: retrofit2.Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    if (response.body() != null) {

                        startActivity(Intent(this@SignInActivity,MenuActivity::class.java))
                        finish()

                    }
                    else AlertDialog.Builder(this@SignInActivity).setMessage("Неверные данные входа").create().show()


                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    val toast = Toast.makeText(this@SignInActivity,t.message, Toast.LENGTH_SHORT).show()
                }
            })




        }
        else{

            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("ОК",null)
                .create()
                .show()
        }




    }
}