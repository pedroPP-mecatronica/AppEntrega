package com.example.pacoteentrega.data.source.remote.repositorio.login

import com.example.pacoteentrega.data.constants.ConstantsNavigation
import com.example.pacoteentrega.data.source.remote.listener.AutenticacaoListener
import com.example.pacoteentrega.data.source.remote.models.response.AutenticacaoModel
import com.example.pacoteentrega.data.source.remote.repositorio.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepositorio() {

    private val mRemote = RetrofitClient.createService(LoginService::class.java)

    fun login(user: String, password: String, listener: AutenticacaoListener) {
        val call: Call<AutenticacaoModel> = mRemote.autenticar(user, password)

        call.enqueue(object : Callback<AutenticacaoModel> {
            override fun onResponse(call: Call<AutenticacaoModel>, response: Response<AutenticacaoModel>) {
                when(response.code()) {
                    ConstantsNavigation.HTTP.OK -> response.body()?.let { listener.onSucessToken(it) }
                    ConstantsNavigation.HTTP.DADO_INVALIDO -> listener.onFailureToken(ConstantsNavigation.MENSAGEM_USUARIO.DADOS_INVALIDOS)
                    else ->listener.onFailureToken(response.message())
                }
            }

            override fun onFailure(call: Call<AutenticacaoModel>, t: Throwable) {
                listener.onFailureToken(ConstantsNavigation.MENSAGEM_USUARIO.ALGO_INESPERADO)
            }

        })

    }
}