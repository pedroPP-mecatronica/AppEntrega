package com.example.pacoteentrega.infra
import retrofit2.Response
import retrofit2.http.POST


interface LoginService {
    @POST("token")
    fun autenticar(codigoUsuario: String, senha: String) : Response<LoginModel>
}