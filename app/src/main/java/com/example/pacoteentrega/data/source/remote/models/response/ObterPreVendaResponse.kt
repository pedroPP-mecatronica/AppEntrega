package com.example.pacoteentrega.data.source.remote.models.response

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

class ObterPreVendaResponse(
    @SerializedName("Mensagem")
    val mensagem: String,
    @SerializedName("Objeto")
    val objeto: PrevendaDados,
    @SerializedName("Sucesso")
    val sucesso: Int,
    @SerializedName("IdGerado")
    val idGerado: Long?
)

class PrevendaDados(
    @SerializedName("PreVenda")
    val preVenda: PreVendaDadosItem,
    @SerializedName("RecebimentoPreVenda")
    val recebimentoPreVenda: RecebimentoPreVenda,
    @SerializedName("TipoRetorno")
    val tipoRetorno: Int
)

class PreVendaDadosItem(
    @SerializedName("Id")
    val id: Long,
    @SerializedName("Valor")
    val valor: Float,
    @SerializedName("CodigoGuia")
    val codigoGuia: String,
    @SerializedName("CodigoPreVenda")
    val codigoPreVenda: String,
    @SerializedName("NomeGuia")
    val nomeGuia: String,
    @SerializedName("CodigoCliente")
    val codigoCliente: String,
    @SerializedName("NomeCliente")
    val nomeCliente: String,
    @SerializedName("IdFilial")
    val idFilial: Long,
    @SerializedName("DataCadastro")
    val dataCadastro: String,
    @SerializedName("Itens")
    val itens: List<Itens>
)

class RecebimentoPreVenda(
    @SerializedName("Id")
    val id: Long,
    @SerializedName("Valor")
    val valor: Float,
    @SerializedName("IdCliente")
    val idCliente: Long,
    @SerializedName("Data")
    val data: String,
    @SerializedName("Codigo")
    val codigo: String,
    @SerializedName("CodigoCliente")
    val codigoCliente: String,
    @SerializedName("CodigoGuia")
    val codigoGuia: String,
    @SerializedName("IdVendedor")
    val idVendedor: Long,
    @SerializedName("DataHoraAbertura")
    val dataHoraAbertura: String,
    @SerializedName("Itens")
    val itens: ArrayList<Itens>,
    @SerializedName("TipoPreVenda")
    val tipoPreVenda: Int,
    @SerializedName("NomeGuia")
    val nomeGuia: String,
    @SerializedName("Status")
    val status: Int,
    @SerializedName("Entregue")
    val entregue: Int,
    @SerializedName("NumeroParcelas")
    val numeroParcelas: Int,
    @SerializedName("DDDCelular")
    val dddCelular: String,
    @SerializedName("Celular")
    val celular: String,
    @SerializedName("CodigoTabelaFinanciamento")
    val codigoTabelaFinanciamento: String,
    @SerializedName("IdDocumentoPagar")
    val idDocumentoPagar: Long,
    @SerializedName("StatusBiometria")
    val statusBiometria: Int,
    @SerializedName("DataHoraBiometria")
    val dataHoraBiometria: String,
    @SerializedName("PercentualBiometria")
    val percentualBiometria: Float,
    @SerializedName("MeioUtilizado")
    val meioUtilizado: Int,
    @SerializedName("CodigoCartaoHavan")
    val codigoCartaoHavan: String,
    @SerializedName("Guid")
    val guid: UUID,
    @SerializedName("CodigoVendedor")
    val codigoVendedor: String
)

class Itens(
    @SerializedName("Id")
    val id: Long,
    @SerializedName("Quantidade")
    val quantidade: Int,
    @SerializedName("IdVariacaoProduto")
    val idVariacaoProduto: Long,
    @SerializedName("ValorAcrescimo")
    val valorAcrescimo: Float,
    @SerializedName("ValorDesconto")
    val valorDesconto: Float,
    @SerializedName("ValorDescontoPromocao")
    val valorDescontoPromocao: Float,
    @SerializedName("PrecoUnitario")
    val precoUnitario: Float,
    @SerializedName("PrecoUnitarioOriginal")
    val precoUnitarioOriginal: Float,
    @SerializedName("ValorTotalFinal")
    val valorTotalFinal: Float,
    @SerializedName("CodigoLido")
    val codigoLido: String,
    @SerializedName("IdVendedor")
    val idVendedor: Long,
    @SerializedName("CodigoVendedor")
    val codigoVendedor: String,
    @SerializedName("DataHoraItem")
    val dataHoraItem: String,
    @SerializedName("NumeroSerieProduto")
    val numeroSerieProduto: String,
    @SerializedName("IdPromocao")
    val idPromocao: Long,
    @SerializedName("CodigoPromocao")
    val codigoPromocao: String,
    @SerializedName("NumeroItem")
    val numeroItem: Float,
    @SerializedName("CodigoTabelaFinanciamento")
    val codigoTabelaFinanciamento: String,
    @SerializedName("PrecoOriginal")
    val precoOriginal: Float,
    @SerializedName("Extensoes")
    val extensoes: List<Extensoes>,
    @SerializedName("DescontoPromocaoItlsys")
    val valorDescontoPromocaoItlsys: Float,
    @SerializedName("ValorTotalOriginal")
    val valorTotalOriginal: Float,
    @SerializedName("PrecoUnitarioVenda")
    val precoUnitarioVenda: Float,
    @SerializedName("CodigoKit")
    val codigoKit: String,
    @SerializedName("CodigoMotivoDesconto")
    val codigoMotivoDesconto: String,
    @SerializedName("CodigoUsuarioDesconto")
    val codigoUsuarioDesconto: String,
    @SerializedName("GuidVariacao")
    val guidVariacao: UUID,
    @SerializedName("Guid")
    val guid: UUID
)

class Extensoes(
    @SerializedName("IdVariacaoProduto")
    val idVariacaoProduto: Long,
    @SerializedName("CodigoLido")
    val codigoLido: String,
    @SerializedName("Valor")
    val valor: Float,
    @SerializedName("IdVendedor")
    val idVendedor: Long,
    @SerializedName("IdItemPreVendaServico")
    val idItemPreVendaServico: Long,
    @SerializedName("Origem")
    val origem: Int,
    @SerializedName("IdAssinatura")
    val idAssinatura: Long,
    @SerializedName("IdProdutoServicoPropostas")
    val idProdutoServicoPropostas: Long,
    @SerializedName("CodigoProdutoServico")
    val codigoProdutoServico: Long,
    @SerializedName("DescricaoProdutoServico")
    val descricaoProdutoServico: String,
    @SerializedName("GuidVendaOriginal")
    val guidVendaOriginal: UUID,
    @SerializedName("GuidProdutoServicoPremios")
    val guidProdutoServicoPremios: UUID,
    @SerializedName("NumeroItemOriginal")
    val numeroItemOriginal: Long,
    @SerializedName("TdProdutoServico")
    val tdProdutoServico: String,
    @SerializedName("CodigoProposta")
    val codigoProposta: Long,
    @SerializedName("CodigoSituacaoProposta")
    val codigoSituacaoProposta: Long,
    @SerializedName("GuidItemServicoProposta")
    val guidItemServicoProposta: UUID,
    @SerializedName("GuidItemPreVendaServico")
    val guidItemPreVendaServico: UUID
)

