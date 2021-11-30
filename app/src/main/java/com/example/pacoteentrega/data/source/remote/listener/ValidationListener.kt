package com.example.pacoteentrega.data.source.remote.listener

class ValidationListener(message: String = "") {

    private var mMessage = ""
    private var mStatus = true

    init {
        if (message != "") {
            mMessage = message
            mStatus = false
        }
    }
    fun message() = mMessage

    fun status() = mStatus
}