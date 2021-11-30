package com.example.pacoteentrega.data.source.local

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    val mSharedPreferences: SharedPreferences =
        context.getSharedPreferences("DB", Context.MODE_PRIVATE)


    fun storeString(key: String, value: String) {
        this.mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return this.mSharedPreferences.getString(key, "") ?: ""
    }

    fun deleteToken(key: String){
        this.mSharedPreferences.edit().remove(key).apply()
    }

}
