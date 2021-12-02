package com.example.pacoteentrega.data.source.local

import android.content.Context
import android.content.SharedPreferences
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Cache(context: Context) {

    val cache: SharedPreferences =
        context.getSharedPreferences("DB", Context.MODE_PRIVATE)


    fun storeString(key: String, value: String) {
        this.cache.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return this.cache.getString(key, "") ?: ""
    }

    fun storeDadosCache(key: String, value: DadosUsuarioModel) {
        this.cache.edit().putString(key, Gson().toJson(value)).apply()
    }

    fun getDadosCache(key: String): DadosUsuarioModel {
        val json = this.cache.getString(key, "")

        val listType = object : TypeToken<DadosUsuarioModel?>() {}.type
        val dados: DadosUsuarioModel = Gson().fromJson(json, listType)

        return dados
    }
}
