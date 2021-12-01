package com.example.pacoteentrega.data.source.remote.repositorio.prevenda

import android.app.Application
import com.example.pacoteentrega.data.constants.ConstantsNavigation
import com.example.pacoteentrega.data.source.local.SecurityPreferences
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
        guidFilial: String,
        codigoEmpresa: String,
        codigoFilial: String,
        codigoPreVenda: String,
        codigoUsuario: String,
        dataHoje: String,
        tiposPreVenda: Int,
        qtdPorPagina: Int,
        paginaAtual: Int,
        token: String,
        listener: PrevendaListener
    ) {
        val call: Call<ObterPreVendaResponse> = mRemote.obterprevenda(
            ObterPrevendaResquest(
                guidFilial,
                codigoEmpresa,
                codigoFilial,
                codigoPreVenda,
                codigoUsuario,
                dataHoje,
                tiposPreVenda,
                qtdPorPagina,
                paginaAtual,
            ), token
        )

        call.enqueue(object : Callback<ObterPreVendaResponse> {
            override fun onResponse(
                call: Call<ObterPreVendaResponse>,
                response: Response<ObterPreVendaResponse>
            ) {
                when (response.code()) {
                    ConstantsNavigation.HTTP.OK -> response.body()
                        ?.let { listener.onSucessPreVenda(it) }
                    ConstantsNavigation.HTTP.DADO_INVALIDO -> listener.onFailurePrevenda(
                        ConstantsNavigation.MENSAGEM_USUARIO.DADOS_INVALIDOS
                    )
                    else -> listener.onFailurePrevenda(response.message())
                }
            }

            override fun onFailure(call: Call<ObterPreVendaResponse>, t: Throwable) {
                listener.onFailurePrevenda(ConstantsNavigation.MENSAGEM_USUARIO.ALGO_INESPERADO)
            }

        })

    }
}