package com.example.pacoteentrega.data.source.remote.models.request

import com.google.gson.annotations.SerializedName
import java.util.*

class ObterPrevendaResquest(
    @SerializedName("GuidFilial")
    val guidFilial: String,
    @SerializedName("CodigoEmpresa")
    val codigoEmpresa: String,
    @SerializedName("CodigoFilial")
    val codigoFilial: String,
    @SerializedName("CodigoPreVenda")
    val codigoPreVenda: String,
    @SerializedName("CodigoUsuario")
    val codigoUsuario: String,
    @SerializedName("DataHoje")
    val dataHoje: String,
    @SerializedName("TiposPreVenda")
    val tiposPreVenda: Int,
    @SerializedName("QtdPorPagina")
    val qtdPorPagina: Int,
    @SerializedName("PaginaAtual")
    val paginaAtual: Int
)