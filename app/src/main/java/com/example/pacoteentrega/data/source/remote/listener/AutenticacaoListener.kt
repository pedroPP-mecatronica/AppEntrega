package com.example.pacoteentrega.data.source.remote.listener

import com.example.pacoteentrega.data.source.remote.models.response.AutenticacaoModel

interface AutenticacaoListener {
    fun onSucessToken(model: AutenticacaoModel){

    }
    fun onFailureToken(message: String) {

    }
}