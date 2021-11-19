package com.example.pacoteentrega.ui

import com.example.pacoteentrega.infra.LoginService
import com.example.pacoteentrega.infra.RetrofitClient


class LoginViewModel {

     fun autenticacao(usuario: String, senha: String) {
        val service = RetrofitClient.createService(LoginService::class.java)
        val response = service.autenticar(usuario,senha)
    }

}