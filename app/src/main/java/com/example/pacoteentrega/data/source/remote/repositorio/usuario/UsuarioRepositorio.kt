package com.example.pacoteentrega.data.source.remote.repositorio.usuario

import android.app.Application
import com.example.pacoteentrega.data.source.remote.models.request.UsuarioModelResquest
import com.example.pacoteentrega.data.source.remote.models.response.UsuarioModel
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.local.Cache
import com.example.pacoteentrega.data.source.remote.listener.UsuarioListener
import com.example.pacoteentrega.data.source.remote.repositorio.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioRepositorio(application: Application) {

    private var mSharedPreferences = Cache(application)
    private val mRemote = RetrofitClient.createService(UsuarioService::class.java)

    fun usuario(usuario: String, ipAparelho: String, listener: UsuarioListener) {

        val token = mSharedPreferences.getString(Navigation.LOGIN.TOKEN)
        val call = mRemote.buscarUsuarioLogin(UsuarioModelResquest(usuario, ipAparelho), token)

        call.enqueue(object : Callback<UsuarioModel> {
            override fun onResponse(
                call: Call<UsuarioModel>,
                response: Response<UsuarioModel>
            ) {
[]                if (response.code() == Navigation.HTTP.OK) {
                    response.body()?.let { listener.onSucessUsuario(it) }
                } else {
                    listener.onFailureUsuario(response.message())
                }
            }

            override fun onFailure(call: Call<UsuarioModel>, t: Throwable) {
                listener.onFailureUsuario(t.message.toString())
            }

        })
    }
}