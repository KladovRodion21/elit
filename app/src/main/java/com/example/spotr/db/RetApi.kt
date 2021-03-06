package com.example.spotr.db


import com.example.spotr.db.Login
import retrofit2.Call
import retrofit2.http.*

interface RetApi {
    @POST("user/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<Login>

    @POST("auth/register")
    fun registration(@Body hashMap: HashMap<String, String>): Call<Void>
}
