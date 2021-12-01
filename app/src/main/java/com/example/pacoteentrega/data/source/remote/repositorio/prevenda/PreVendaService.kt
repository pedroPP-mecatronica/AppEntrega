package com.example.pacoteentrega.data.source.remote.repositorio.prevenda

import com.example.pacoteentrega.data.source.remote.models.request.ObterPrevendaResquest
import com.example.pacoteentrega.data.source.remote.models.response.ObterPreVendaResponse
import com.example.pacoteentrega.data.source.remote.repositorio.Rotas
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*

interface PreVendaService {

    @POST("{urlBase}api/PreVenda/ObterPreVendas")
    fun obterprevenda(
        @Body modelo: ObterPrevendaResquest,
        @Header("Authorization") authorization: String,
        @Path("urlBase", encoded = true) urlbase: String = Rotas.URL_BASE_PDV_MOBILE,
    ): Call<ObterPreVendaResponse>

}