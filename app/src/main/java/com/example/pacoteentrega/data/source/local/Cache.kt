package com.example.pacoteentrega.data.source.local

import android.content.Context
import android.content.SharedPreferences
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioModel
import com.example.pacoteentrega.data.source.remote.models.response.Itens
import com.example.pacoteentrega.data.source.remote.models.response.PrevendaDados
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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

        return Gson().fromJson(json, listType)
    }


    fun storeItensCache(key: String, value: List<Itens>) {
        this.cache.edit().putString(key, Gson().toJson(value)).apply()
    }

    fun getItensCache(key: String): List<Itens>? {
        val json = this.cache.getString(key, "")

        val listType = object : TypeToken<List<Itens?>?>() {}.type

        return Gson().fromJson<List<Itens>?>(json, listType)
    }

}
