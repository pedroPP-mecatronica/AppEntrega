package com.example.pacoteentrega.data.source.remote.repositorio.prevenda

import android.app.Application
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.remote.listener.PrevendaListener
import com.example.pacoteentrega.data.source.remote.models.request.ObterPrevendaResquest
import com.example.pacoteentrega.data.source.remote.repositorio.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PreVendaRepositorio(application: Application) {


    private val mRemote = RetrofitClient.createService(PreVendaService::class.java)

    fun buscarPreVenda(
        guidFilial: String,
        codigoPreVenda: String,
        token: String,
        listener: PrevendaListener
    ) {
        val call = mRemote.obterprevenda(
            ObterPrevendaResquest(
                codigoPreVenda,
                guidFilial
            ), token
        )

        call.enqueue(object : Callback<Any> {
            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>
            ) {
                when (response.code()) {
                    Navigation.HTTP.OK -> response.body()
                        ?.let { listener.onSucessPreVenda(it) }
                    Navigation.HTTP.DADO_INVALIDO -> listener.onFailurePrevenda(
                        Navigation.MENSAGEM_USUARIO.NAO_ENCONTRADO
                    )
                    else -> listener.onFailurePrevenda(response.message())
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                listener.onFailurePrevenda(Navigation.MENSAGEM_USUARIO.ALGO_INESPERADO)
            }

        })

    }
}