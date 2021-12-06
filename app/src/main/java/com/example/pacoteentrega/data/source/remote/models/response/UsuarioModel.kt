package com.example.pacoteentrega.data.source.remote.models.response

import com.google.gson.annotations.SerializedName
import java.util.*

data class UsuarioModel
    (
    @SerializedName("CodigoEmpresa")
    val codigoEmpresa : String,
    @SerializedName("CodigoFilial")
    val codigoFilial : String,
    @SerializedName("CodigoPerfilAcesso")
    val codigoPerfilAcesso : String,
    @SerializedName("LocalEstoque")
    val localEstoque : String,
    @SerializedName("TipoEstoque")
    val tipoEstoque : Int,
    @SerializedName("Codigo")
    val codigo: String,
    @SerializedName("GuidFilial")
    val guidFilial: UUID,
    @SerializedName("NomeFilial")
    val nomeFilial: String,
    @SerializedName("GuidUsuario")
    val guidUsuario: String,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("IdPerfil")
    val idPerfil : Int,
    @SerializedName("Nome")
    val nome: String,
    @SerializedName("EhVendedor")
    val ehVendedor: Boolean,

)