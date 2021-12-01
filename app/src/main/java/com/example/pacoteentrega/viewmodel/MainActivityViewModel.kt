package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.source.remote.listener.ValidationListener
import com.example.pacoteentrega.data.source.remote.models.response.UsuarioModel
import com.example.pacoteentrega.data.constants.ConstantsNavigation
import com.example.pacoteentrega.data.source.local.SecurityPreferences
import com.example.pacoteentrega.data.source.remote.repositorio.usuario.UsuarioRepositorio
import com.example.pacoteentrega.data.source.remote.listener.UsuarioListener
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioMenuModel

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val mLoginRepository = UsuarioRepositorio(application)
    private val mSharedPreferences = SecurityPreferences(application)


    private var mUsuario = MutableLiveData<DadosUsuarioMenuModel>()
    var usuario: LiveData<DadosUsuarioMenuModel> = mUsuario

    private var mError = MutableLiveData<String>()
    var error: LiveData<String> = mError


    fun buscarDados() {
        val ipAparelho = "172.17.200.253"
        val usuario = mSharedPreferences.getString(ConstantsNavigation.LOGIN.USUARIO)
        mLoginRepository.usuario(
            usuario,
            ipAparelho,
            object : UsuarioListener {
                override fun onSucessUsuario(model: UsuarioModel) {
                    mUsuario.value = DadosUsuarioMenuModel(model.codigo, model.nomeFilial, model.nome)
                }

                override fun onFailureUsuario(message: String) {
                    mError.value = message
                }
            }
        )
    }

}