package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.remote.repositorio.login.LoginRepositorio
import com.example.pacoteentrega.data.source.local.Cache
import com.example.pacoteentrega.data.source.remote.listener.AutenticacaoListener
import com.example.pacoteentrega.data.source.remote.listener.ValidationListener
import com.example.pacoteentrega.data.source.remote.models.response.AutenticacaoModel


class LoginViewModel(application: Application) : AndroidViewModel(application) {


    private val mSharedPreferences = Cache(application)
    private val mLoginRepository = LoginRepositorio()


    private var mLogin = MutableLiveData<ValidationListener>()
    var login: LiveData<ValidationListener> = mLogin

    fun autenticacao(usuario: String, senha: String) {

        mLoginRepository.login(
            usuario,
            senha,
            object : AutenticacaoListener {
                override fun onSucessToken(model: AutenticacaoModel) {
                    mSharedPreferences.storeString(
                        Navigation.LOGIN.TOKEN,
                        model.access_token
                    )
                    mSharedPreferences.storeString(Navigation.LOGIN.USUARIO, usuario)
                    mLogin.value = ValidationListener()
                }

                override fun onFailureToken(message: String) {
                    mLogin.value = ValidationListener(message)
                }
            }
        )
    }
}