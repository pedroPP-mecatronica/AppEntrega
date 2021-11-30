package com.example.pacoteentrega.data.source.remote.listener

import com.example.pacoteentrega.data.source.remote.models.response.UsuarioModel

interface UsuarioListener {

    fun onSucessUsuario(model: UsuarioModel) {}

    fun onFailureUsuario(message: String) {}

}