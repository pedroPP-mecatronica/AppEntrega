package com.example.pacoteentrega.data.source.remote.models.mapper

import java.util.*

data class DadosUsuarioModel(
    val codigoUsuario: String,
    val filial: String,
    val nome: String,
    val guidFilial: UUID,
    val codigoEmpresa: String,
    val codigoFilial: String,
)