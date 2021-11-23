package com.example.spotr

data class Login(val token: Int){
    companion object Login{
        var userToken: Int? = null
    }
}