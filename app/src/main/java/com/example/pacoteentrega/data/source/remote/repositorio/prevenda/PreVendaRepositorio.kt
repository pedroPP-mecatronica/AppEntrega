package com.example.pacoteentrega.data.source.remote.repositorio.prevenda

import android.app.Application
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.remote.listener.PrevendaListener
import com.example.pacoteentrega.data.source.remote.models.request.ObterPrevendaResquest
import com.example.pacoteentrega.data.source.remote.models.response.ObterPreVendaResponse
import com.example.pacoteentrega.data.source.remote.repositorio.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class PreVendaRepositorio(application: Application) {

    private val mRemote = RetrofitClient.createService(PreVendaService::class.java)

    fun buscarPreVenda(
        guidFilial: UUID,
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

        call.enqueue(object : Callback<ObterPreVendaResponse> {
            override fun onResponse(
                call: Call<ObterPreVendaResponse>,
                response: Response<ObterPreVendaResponse>
            ) {
                if (response.code() == Navigation.HTTP.OK) {
                    when(response.body()?.mensagem.toString()){
                        Navigation.DATANULL.NULL -> response.body()
                            ?.let { listener.onSucessPreVenda(it) }
                        else -> listener.onFailurePrevenda(response.body()?.mensagem.toString())
                    }
                } else {
                    listener.onFailurePrevenda(response.message())
                }
            }

            override fun onFailure(call: Call<ObterPreVendaResponse>, t: Throwable) {
                listener.onFailurePrevenda(t.message.toString())
            }

        })

    }
}