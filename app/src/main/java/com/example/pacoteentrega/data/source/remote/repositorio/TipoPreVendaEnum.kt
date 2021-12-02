package com.example.pacoteentrega.data.source.remote.repositorio

import com.google.gson.annotations.SerializedName


enum class TipoPreVendaEnum(val tipo: String, val enum: Int) {
    @SerializedName("0")
    Normal("Normal", 0),
    @SerializedName("1")
    Futura("Futura", 1),
    @SerializedName("2")
    Ordem("Ordem", 2),
    @SerializedName("3")
    ProdutoPresente("Produto Presente", 3),
    @SerializedName("4")
    PosVendaGarantia("Pos venda garantia", 4),
    @SerializedName("5")
    CheckoutRemoto("Remoto Omnichannel", 5),
    @SerializedName("7")
    NA("Valor nulo", 7)
}
