package com.example.pacoteentrega.service.listener

import com.example.pacoteentrega.service.models.LoginModel

interface APIListener {
    fun onSucess(model: LoginModel){

    }
    fun onFailure(toString: String) {

    }
}