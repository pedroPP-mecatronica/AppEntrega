package com.example.pacoteentrega.data.source.remote.listener


interface PrevendaListener {
    fun onSucessPreVenda(model: Any) {}

    fun onFailurePrevenda(message: String) {}
}