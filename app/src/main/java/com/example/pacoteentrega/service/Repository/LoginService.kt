package com.example.pacoteentrega.service.Repository
import com.example.pacoteentrega.service.models.LoginModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface LoginService {
    @POST("oauth/token")
    @FormUrlEncoded
    fun autenticar( @Field("username") user: String,
                    @Field("password") passwrd: String,
                    @Field("grant_type")grant_type: String = "password",
    ):Call<LoginModel>

}