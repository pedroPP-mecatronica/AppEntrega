package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.local.Cache
import com.example.pacoteentrega.data.source.remote.listener.PrevendaListener
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioModel
import com.example.pacoteentrega.data.source.remote.models.response.ObterPreVendaResponse
import com.example.pacoteentrega.data.source.remote.repositorio.prevenda.PreVendaRepositorio
import java.util.*

class BuscarPrevendaViewModel(application: Application) : AndroidViewModel(application) {


    private val mPreVendaRepositorio = PreVendaRepositorio(application)
    private val cache = Cache(application)

    private var mPreVenda = MutableLiveData<ObterPreVendaResponse>()
    var preVenda: LiveData<ObterPreVendaResponse> = mPreVenda

    private var mError = MutableLiveData<String>()
    var error: LiveData<String> = mError


    //Buscar de acordo com os dados Usuario
    private val dadosUsuario: DadosUsuarioModel =
        cache.getDadosCache(Navigation.USUARIO.DADOS_USUARIO)


    private var guidFilial: UUID = dadosUsuario.guidFilial
    var codigoPreVenda: String = ""


    fun buscarPreVenda() {
        val token = cache.getString(Navigation.LOGIN.TOKEN)

        mPreVendaRepositorio.buscarPreVenda(
            guidFilial,
            codigoPreVenda,
            token,
            object : PrevendaListener {
                override fun onSucessPreVenda(model: ObterPreVendaResponse) {
                    salvarPreVenda(model)
                    mPreVenda.value = model
                }

                override fun onFailurePrevenda(message: String) {
                    mError.value = message
                }
            }
        )

    }

    private fun salvarPreVenda(model: ObterPreVendaResponse) {
        val itens = model.objeto.preVenda.itens
        val cliente = model.objeto.preVenda.nomeCliente

        cache.storeItensCache(Navigation.PREVENDA.ITENS, itens)
        cache.storeString(Navigation.PREVENDA.CLIENTE, cliente)
        cache.storeString(Navigation.PREVENDA.PRE_VENDA, codigoPreVenda)
    }

}