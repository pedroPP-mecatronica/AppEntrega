package com.example.pacoteentrega.service.models

import com.google.gson.annotations.SerializedName

class LoginModel {
    var access_token: String = ""
    var token_type: String = ""
    var expires_in: String = ""
    var refresh_token: String = ""
    var refresh_token_expires_in: String = ""
}