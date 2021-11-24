package com.example.pacoteentrega.service.Repository.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    val mSharedPreferences: SharedPreferences =
        context.getSharedPreferences("token", Context.MODE_PRIVATE)


    fun storeToken(key: String, value: String) {
        this.mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getToken(key: String): String {
        return this.mSharedPreferences.getString(key, "") ?: ""
    }

}
