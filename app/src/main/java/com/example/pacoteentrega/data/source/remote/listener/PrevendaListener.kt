package com.example.pacoteentrega.data.source.remote.listener

import com.example.pacoteentrega.data.source.remote.models.response.ObterPreVendaResponse
import com.example.pacoteentrega.data.source.remote.models.response.UsuarioModel

interface PrevendaListener {
    fun onSucessPreVenda(model: ObterPreVendaResponse) {}

    fun onFailurePrevenda(message: String) {}
}