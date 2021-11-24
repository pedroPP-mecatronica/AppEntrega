package com.example.pacoteentrega.viewmodel

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.service.LoginRepository
import com.example.pacoteentrega.service.Repository.local.SecurityPreferences
import com.example.pacoteentrega.service.listener.APIListener
import com.example.pacoteentrega.service.models.LoginModel
import com.google.android.material.shape.ShapeAppearancePathProvider.getInstance
import java.util.Currency.getInstance


class LoginViewModel(application: Application) : AndroidViewModel(application) {


    private val mContext = application.applicationContext
    private lateinit var mSharedPreferences: SecurityPreferences
    private val mLoginRepository = LoginRepository()


    private val mLogin = MutableLiveData<Boolean>()
    val login:LiveData<Boolean> = mLogin

    fun autenticacao(usuario: String, senha: String) {
        mLoginRepository.login(usuario, senha, object : APIListener {
            override fun onSucess(model: LoginModel) {
                super.onSucess(model)
                mLogin.value = true
                SecurityPreferences(mContext).storeToken("token",model.access_token)
            }

            override fun onFailure(toString: String) {
                super.onFailure(toString)
                mLogin.value = false
            }
        })
    }
}