package com.example.pacoteentrega.data.constants

class Navigation private constructor() {

    object LOGIN{
        const val TOKEN = "token"
        const val USUARIO = "usuario"
        const val DADOS_USUARIO ="dados"
    }

    object MENSAGEM_USUARIO {
        const val FALTA_DADOS = "Preencha todos os campos"
        const val DADOS_INVALIDOS = "Dados inválidos"
        const val SUCESSO = "Sucesso"
        const val ALGO_INESPERADO = "Algo inesperado aconteceu, tente novamente"
        const val NAO_ENCONTRADO = "Pré-venda não encontrada"
    }

    object HTTP {
        const val OK = 200
        const val DADO_INVALIDO = 400
    }

    object DATAERROR{
        const val NULL = ""
    }


}