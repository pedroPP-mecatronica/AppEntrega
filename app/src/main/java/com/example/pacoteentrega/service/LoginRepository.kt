package com.example.pacoteentrega.service

import com.example.pacoteentrega.service.Repository.remote.LoginService
import com.example.pacoteentrega.service.Repository.remote.RetrofitClient
import com.example.pacoteentrega.service.listener.APIListener
import com.example.pacoteentrega.service.models.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
    private val mRemote = RetrofitClient.createService(LoginService::class.java)
    fun login(user: String, password: String,listener: APIListener) {
        val call: Call<LoginModel> = mRemote.autenticar(user, password)
        val permite:Boolean=false

        call.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                response.body()?.let { listener.onSucess(it) }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })

    }
}