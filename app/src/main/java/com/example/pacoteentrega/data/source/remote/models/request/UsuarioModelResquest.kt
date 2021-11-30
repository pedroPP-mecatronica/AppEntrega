package com.example.pacoteentrega.data.source.remote.models.request

import com.google.gson.annotations.SerializedName

class UsuarioModelResquest (
    @SerializedName("CodigoUsuario")
    val codigoUsuario: String,
    @SerializedName("IpAparelho")
    val ipAparelho: String
)
