package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.source.remote.models.response.UsuarioModel
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.local.Cache
import com.example.pacoteentrega.data.source.remote.repositorio.usuario.UsuarioRepositorio
import com.example.pacoteentrega.data.source.remote.listener.UsuarioListener
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val mLoginRepository = UsuarioRepositorio(application)
    private val mSharedPreferences = Cache(application)


    private var mUsuario = MutableLiveData<DadosUsuarioModel>()
    var usuario: LiveData<DadosUsuarioModel> = mUsuario

    private var mError = MutableLiveData<String>()
    var error: LiveData<String> = mError


    fun buscarDados() {
        val ipAparelho = "172.17.200.253"
        val usuario = mSharedPreferences.getString(Navigation.LOGIN.USUARIO)
        mLoginRepository.usuario(
            usuario,
            ipAparelho,
            object : UsuarioListener {
                override fun onSucessUsuario(model: UsuarioModel) {
                    val dadosUsuario = DadosUsuarioModel(
                        model.codigo,
                        model.nomeFilial,
                        model.nome,
                        model.guidFilial,
                        model.codigoEmpresa,
                        model.codigoFilial
                    )
                    mSharedPreferences.storeDadosCache(Navigation.LOGIN.DADOS_USUARIO,dadosUsuario)
                    mUsuario.value =
                        DadosUsuarioModel(
                            model.codigo,
                            model.nomeFilial,
                            model.nome,
                            model.guidFilial,
                            model.codigoEmpresa,
                            model.codigoFilial
                        )
                }

                override fun onFailureUsuario(message: String) {
                    mError.value = message
                }
            }
        )
    }

}