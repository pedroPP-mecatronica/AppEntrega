package com.example.pacoteentrega.data.constants

class ConstantsNavigation private constructor() {

    object LOGIN{
        const val TOKEN = "token"
        const val USUARIO = "usuario"
    }

    object MENSAGEM_USUARIO {
        const val FALTA_DADOS = "Preencha todos os campos"
        const val DADOS_INVALIDOS = "Dados inválidos"
        const val SUCESSO = "Sucesso"
        const val ALGO_INESPERADO = "Algo inesperado aconteceu, tente novamente"
    }

    object HTTP {
        const val OK = 200
        const val DADO_INVALIDO = 400
    }

    object DATAERROR{
        const val NULL = ""
    }


}