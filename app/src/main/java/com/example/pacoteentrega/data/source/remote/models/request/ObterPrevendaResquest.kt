package com.example.pacoteentrega.data.source.remote.models.request

import com.google.gson.annotations.SerializedName
import java.util.*

class ObterPrevendaResquest(
    @SerializedName("CodigoPreVenda")
    val codigoPreVenda: String,
    @SerializedName("GuidFilial")
    val guidFilial: UUID,
)