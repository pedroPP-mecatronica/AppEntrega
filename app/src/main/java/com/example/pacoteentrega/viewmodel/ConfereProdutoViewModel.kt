package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.local.Cache
import com.example.pacoteentrega.data.source.remote.models.response.Itens

class ConfereProdutoViewModel(application: Application) : AndroidViewModel(application) {

    private val mItens: MutableLiveData<List<Itens>> = MutableLiveData()
    val itens: LiveData<List<Itens>> = mItens

    private val mCliente: MutableLiveData<String> = MutableLiveData()
    val cliente: LiveData<String> = mCliente

    private val mPreVenda: MutableLiveData<String> = MutableLiveData()
    val preVenda: LiveData<String> = mPreVenda

    private val cache = Cache(application)

    fun obterItens() {
        mItens.value = cache.getItensCache(Navigation.PREVENDA.ITENS)
    }

    fun obterPrevenda(){
        mPreVenda.value = cache.getString(Navigation.PREVENDA.PRE_VENDA)
    }
    fun obterCliente(){
        mCliente.value = cache.getString(Navigation.PREVENDA.CLIENTE)
    }
}