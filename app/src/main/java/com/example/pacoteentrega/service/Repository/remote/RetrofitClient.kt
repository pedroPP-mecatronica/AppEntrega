package com.example.pacoteentrega.service.Repository.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {
        //singleton
        companion object {
            private lateinit var retrofit: Retrofit
            private val baseUrl = "https://sistema.havan.com.br/AutenticacaoApi/"

            private fun getRetrofitInstance(): Retrofit {
                var httpClient = OkHttpClient.Builder()
                if (!Companion::retrofit.isInitialized) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }

                return retrofit
            }

            fun <S> createService(serviceClass: Class<S>):S {
                return getRetrofitInstance().create(serviceClass)
            }

        }
    }
