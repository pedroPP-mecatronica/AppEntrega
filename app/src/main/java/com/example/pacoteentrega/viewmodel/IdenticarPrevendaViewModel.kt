package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.constants.ConstantsNavigation
import com.example.pacoteentrega.data.source.local.SecurityPreferences
import com.example.pacoteentrega.data.source.remote.listener.PrevendaListener
import com.example.pacoteentrega.data.source.remote.listener.UsuarioListener
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosPreVendaModel
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioMenuModel
import com.example.pacoteentrega.data.source.remote.models.request.ObterPrevendaResquest
import com.example.pacoteentrega.data.source.remote.models.response.ObterPreVendaResponse
import com.example.pacoteentrega.data.source.remote.models.response.UsuarioModel
import com.example.pacoteentrega.data.source.remote.repositorio.prevenda.PreVendaRepositorio
import com.example.pacoteentrega.data.source.remote.repositorio.usuario.UsuarioRepositorio
import java.util.*

class IdenticarPrevendaViewModel(application: Application) : AndroidViewModel(application) {

    private val mPreVendaRepositorio = PreVendaRepositorio(application)
    private val mSharedPreferences = SecurityPreferences(application)
    private val mLoginRepository = UsuarioRepositorio(application)


    private var mPreVenda = MutableLiveData<DadosPreVendaModel>()
    var preVenda: LiveData<DadosPreVendaModel> = mPreVenda

    private var mError = MutableLiveData<String>()
    var error: LiveData<String> = mError


    //Buscar de acordo com os dados Usuario
    private var codigoEmpresa:String = ""
    private var guidFilial :String = ""
    private var codigoFilial:String = ""
    private var codigoPreVenda:String = ""

    //Armezanado no SharedPreferences
    private var codigoUsuario:String = mSharedPreferences.getString(ConstantsNavigation.LOGIN.USUARIO)

    //
    private var dataHoje:String = ""

    private val ipAparelho = "172.17.200.253"
    private var tiposPreVenda:Int= 0
    private var qtdPorPagina:Int= 0
    private var paginaAtual:Int= 0


    fun buscarDadosUsuario() {

        mLoginRepository.usuario(
            codigoUsuario,
            ipAparelho,
            object : UsuarioListener {
                override fun onSucessUsuario(model: UsuarioModel) {
                    codigoEmpresa = model.codigoEmpresa
                    guidFilial = model.guidFilial
                    codigoFilial = model.codigoFilial
                }

                override fun onFailureUsuario(message: String) {
                    mError.value = message
                }
            }
        )
    }


    fun buscarPreVenda() {

        val usuario = mSharedPreferences.getString(ConstantsNavigation.LOGIN.USUARIO)
        val token = mSharedPreferences.getString(ConstantsNavigation.LOGIN.TOKEN)

        mPreVendaRepositorio.buscarPreVenda(
            guidFilial,
            codigoEmpresa,
            codigoFilial,
            codigoPreVenda,
            codigoUsuario,
            dataHoje,
            tiposPreVenda,
            qtdPorPagina,
            paginaAtual,
            token,
            object : PrevendaListener {
                override fun onSucessPreVenda(model: ObterPreVendaResponse) {
                    mPreVenda.value = model.codigoPreVenda?.let {
                        DadosPreVendaModel(model.valor,
                            it
                        )
                    }
                    }

                override fun onFailurePrevenda(message: String) {
                    mError.value = message
                }
            }
        )

    }

}