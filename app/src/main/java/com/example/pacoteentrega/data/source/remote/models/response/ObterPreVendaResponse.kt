package com.example.pacoteentrega.data.source.remote.models.response

import com.google.gson.annotations.SerializedName
import java.util.*

class ObterPreVendaResponse(
    @SerializedName("Guid")
    val guid: UUID,
    @SerializedName("CodigoPreVenda")
    val codigoPreVenda: String?,
    @SerializedName("CodigoVendedor")
    val codigoVendedor: String?,
    @SerializedName("DataCadastro")
    val dataCadastro: Date?,
    @SerializedName("Id")
    val id: Long,
    @SerializedName("Status")
    val status: Int,
    @SerializedName("TipoPreVenda")
    val tipoPreVenda: Int,
    @SerializedName("ValorFrete")
    val valorFrete: Float,
    @SerializedName("Valor")
    val valor: Float,
    @SerializedName("ValorServicos")
    val valorServicos: Float,
    @SerializedName("UrlPedido")
    val urlPedido: String?,
    @SerializedName("NumerosPedidosItlsys")
    val numerosPedidosItlsys: List<Long>?,
    @SerializedName("Pagamentos")
    val pagamentos: List<PreVendaPagamentoResponseData>?,
    @SerializedName("Cliente")
    val cliente: PreVendaClienteResponseData?,
    @SerializedName("GuidFilial")
    val guidFilial: UUID,
    @SerializedName("EntregaPacote")
    val entregaPacote: Int,
    @SerializedName("MeioUtilizado")
    val meioUtilizado: Int,
    @SerializedName("StatusPagamentoServicos")
    val statusPagamentoServicos: Int?,
    @SerializedName("SequenciaPreVenda")
    val sequenciaPreVenda: Long,
    @SerializedName("ValorEntrada")
    val valorEntrada: Float,
    @SerializedName("DataReabertura")
    val dataReabertura: Date?,
    @SerializedName("Entrega")
    val entrega: PreVendaEntregaResponseData?,
    @SerializedName("CotacoesFrete")
    val cotacoesFrete: List<PreVendaCotacoesFreteResponseData>?,
    @SerializedName("Itens")
    val itens: List<PreVendaProdutoResponseData>?,
    @SerializedName("TipoEntregaOrdem")
    val tipoEntregaOrdem: Int,
    @SerializedName("GuidFilialEntrega")
    val guidFilialEntrega: UUID? = null,
)


data class PreVendaPagamentoResponseData(
    @SerializedName("IdPreVenda")
    val idPreVenda: Long,
    @SerializedName("FormaPagamento")
    val formaPagamento: Int,
    @SerializedName("StatusBiometria")
    val statusBiometria: Int,
    @SerializedName("GuidCartao")
    val guidCartao: String?,
    @SerializedName("Cliente")
    val cliente: PreVendaClienteResponseData?,
    @SerializedName("IdPreVendaCheckoutRemoto")
    val idPreVendaCheckoutRemoto: Long,
    @SerializedName("FormaCapturaCartão")
    val formaCapturaCartao: Int?,
    @SerializedName("NumeroParcelas")
    val numeroParcelas: Int?,
    @SerializedName("TemEntrada")
    val temEntrada: Int?,
    @SerializedName("GuidPreVenda")
    val guidPreVenda: UUID?,
    @SerializedName("Financiamentos")
    val financiamentos: List<PreVendaFinanciamentosResponseData>? = null,
)

data class PreVendaClienteResponseData(
    @SerializedName("CodigoCliente")
    val codigoCliente: String?,
    @SerializedName("NomeCliente")
    val nomeCliente: String?,
    @SerializedName("Documento")
    val cpf: String?,
    @SerializedName("DDDCelular")
    val dddCelular: String?,
    @SerializedName("Celular")
    val celular: String?,
    @SerializedName("Email")
    val email: String?,
    @SerializedName("GuidPreVenda")
    val guidPreVenda: UUID,
)

data class PreVendaEntregaResponseData(
    @SerializedName("Id")
    val id: Long,
    @SerializedName("IdPreVenda")
    val idPreVenda: Long,
    @SerializedName("Avarias")
    val avarias: Int?,
    @SerializedName("BairroEntrega")
    val bairroEntrega: String?,
    @SerializedName("CodigoCepEntrega")
    val codigoCepEntrega: String?,
    @SerializedName("ComplementoEntrega")
    val complementoEntrega: String?,
    @SerializedName("DataPrevisaoEntrega")
    val dataPrevisaoEntrega: Date?,
    @SerializedName("EmailEntrega")
    val emailEntrega: String?,
    @SerializedName("EnderecoEntrega")
    val enderecoEntrega: String?,
    @SerializedName("EntreguePelaEmpresa")
    val entreguePelaEmpresa: Int?,
    @SerializedName("NumeroEnderecoEntrega")
    val numeroEnderecoEntrega: String?,
    @SerializedName("ObservacoesEntrega")
    val observacoesEntrega: String?,
    @SerializedName("PeriodoEntrega")
    val periodoEntrega: Int,
    @SerializedName("PessoaAutorizada")
    val pessoaAutorizada: String?,
    @SerializedName("Volumes")
    val volumes: Int?,
    @SerializedName("CidadeEntrega")
    val cidadeEntrega: String?,
    @SerializedName("EstadoEntrega")
    val estadoEntrega: String?,
    @SerializedName("DDDEntrega")
    val dddEntrega: String?,
    @SerializedName("TelefoneEntrega")
    val telefoneEntrega: String?,
    @SerializedName("PontoReferenciaEntrega")
    val pontoReferenciaEntrega: String?,
    @SerializedName("GuidPreVenda")
    val guidPreVenda: UUID,
)

data class PreVendaCotacoesFreteResponseData(
    @SerializedName("IdOferta")
    val idOferta: Long,
    @SerializedName("Transportadora")
    val transportadora: String,
    @SerializedName("Cnpj")
    val cnpj: String,
    @SerializedName("Valor")
    val valor: Float,
    @SerializedName("PrazoEntrega")
    val prazoEntrega: Short,
    @SerializedName("Validade")
    val validade: Date,
    @SerializedName("CodigoTransportadora")
    val codigoTransportadora: String,
    @SerializedName("Guid")
    val guid: UUID,
    @SerializedName("GuidFilial")
    val guidFilial: UUID,
)

data class PreVendaProdutoResponseData(
    @SerializedName("CodigoDigitado")
    val codigoDigitado: String,
    @SerializedName("CodigoProduto")
    val codigoProduto: String,
    @SerializedName("CodigoProdutoVariacao")
    val codigoProdutoVariacao: String,
    @SerializedName("CodigoTipoEstoque")
    val codigoTipoEstoque: Short,
    @SerializedName("CodigoVendedor")
    val codigoVendedor: String,
    @SerializedName("DataHoraItem")
    val dataHoraItem: Date? = null,
    @SerializedName("Item")
    val item: Int,
    @SerializedName("NumeroSerieProduto")
    val numeroSerieProduto: String,
    @SerializedName("OrigemProduto")
    val origemProduto: Short,
    @SerializedName("PrecoOriginal")
    val precoOriginal: Float,
    @SerializedName("PrecoTotalFinal")
    val precoTotalFinal: Float,
    @SerializedName("PrecoUnitarioOriginal")
    val precoUnitarioOriginal: Float,
    @SerializedName("PrecoUnitarioFinal")
    val precoUnitarioFinal: Float,
    @SerializedName("Quantidade")
    val quantidade: Int,
    @SerializedName("SituacaoItem")
    val situacaoItem: Int?,
    @SerializedName("AceitaReserva")
    val aceitaReserva: Int?,
    @SerializedName("TipoFornecedor")
    val tipoFornecedor: Int?,
    @SerializedName("ValorAcrescimo")
    val valorAcrescimo: Float,
    @SerializedName("ValorDesconto")
    val valorDesconto: Float,
    @SerializedName("ValorDescontoPromocao")
    val valorDescontoPromocao: Float,
    @SerializedName("CodigoBarras")
    val codigoBarras: String,
    @SerializedName("GuidDadosCotacaoFrete")
    val guidDadosCotacaoFrete: String?,
    @SerializedName("GuidVariacao")
    val guidVariacao: UUID,
    @SerializedName("Servicos")
    val servicos: List<PreVendaProdutoServicoResponseData>? = null,
    @SerializedName("CodigoPromocao")
    val codigoPromocao: String?,
    @SerializedName("CodigoTabelaFinanciamento")
    val codigoTabelaFinanciamento: String,
    @SerializedName("GuidFilial")
    val guidFilial: String,
    @SerializedName("ValorDescontoPromocaoKit")
    val valorDescontoPromocaoKit: Float,
    @SerializedName("CodigoUsuarioDesconto")
    val codigoVendedorDesconto: String,
    @SerializedName("CodigoMotivoDesconto")
    val codigoMotivoDesconto: String,
    @SerializedName("PercentualDesconto")
    val percentualDesconto: Float,
)

data class PreVendaProdutoServicoResponseData(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("CodigoProdutoServico")
    val codigoProdutoServico: Int,
    @SerializedName("CodigoProposta")
    val codigoProposta: Int,
    @SerializedName("CodigoSituacaoProposta")
    val codigoSituacaoProposta: Int,
    @SerializedName("CodigoUsuarioCancelamento")
    val codigoUsuarioCancelamento: String?,
    @SerializedName("DataCadastro")
    val dataCadastro: Date?,
    @SerializedName("DataCancelamento")
    val dataCancelamento: Date?,
    @SerializedName("DescricaoServico")
    val descricaoServico: String?,
    @SerializedName("Nome")
    val nome: String?,
    @SerializedName("NumeroSerie")
    val numeroSerie: String?,
    @SerializedName("Origem")
    val origem: Int,
    @SerializedName("Valor")
    val valor: Float,
    @SerializedName("IdItemVenda")
    val idItemVenda: Int,
    @SerializedName("Guid")
    val guid: UUID?,
    @SerializedName("GuidVendaOriginal")
    val guidVendaOriginal: UUID?,
    @SerializedName("IdVariacaoProduto")
    val idVariacaoProduto: Int,
    @SerializedName("GuidProdutoServicoPremios")
    val guidProdutoServicoPremios: UUID?,
    @SerializedName("GuidVariacaoProduto")
    val guidVariacaoProduto: UUID?,
    @SerializedName("CodigoLido")
    val codigoLido: String?,
    @SerializedName("NumeroItemOriginal")
    val numeroItemOriginal: Int,
    @SerializedName("DescricaoProdutoServico")
    val descricaoProdutoServico: String?,
    @SerializedName("IdAssinatura")
    val idAssinatura: Long?,
    @SerializedName("IdProdutoServicoPropostas")
    val idProdutoServicoPropostas: Int,
    @SerializedName("GuidItemServicoProposta")
    val guidItemServicoProposta: UUID?,
    @SerializedName("Cor")
    val cor: String?
)

data class PreVendaFinanciamentosResponseData(
    @SerializedName("CodigoTabelaFinanciamento")
    val codigoTabelaFinanciamento: String,
    @SerializedName("CodigoPromocaoFinanciamento")
    val codigoPromocaoFinanciamento: String,
    @SerializedName("NumeroParcelas")
    val numeroParcelas: Int,
    @SerializedName("ValorFinanciamento")
    val valorFinanciamento: Float,
    @SerializedName("ValorParcelaTotal")
    val valorParcelaTotal: Float,
)

