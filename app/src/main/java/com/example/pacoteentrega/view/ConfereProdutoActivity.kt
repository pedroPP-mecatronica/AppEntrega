package com.example.pacoteentrega.view

import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pacoteentrega.R
import com.example.pacoteentrega.data.source.remote.models.response.Itens
import com.example.pacoteentrega.view.adapter.ConfereProdutoAdapter
import com.example.pacoteentrega.viewmodel.ConfereProdutoViewModel
import kotlinx.android.synthetic.main.activity_confere_produto.*
import kotlinx.android.synthetic.main.activity_confere_produto.view.*

class ConfereProdutoActivity : AppCompatActivity() {

    private lateinit var mViewModel: ConfereProdutoViewModel
    private lateinit var adapter: ConfereProdutoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confere_produto)
        mViewModel = ViewModelProvider(this).get(ConfereProdutoViewModel::class.java)
        mViewModel.obterItens()
        mViewModel.obterPrevenda()
        mViewModel.obterCliente()
        observe()
    }

    private fun observe() {
        mViewModel.itens.observe(this,{ itens ->
            adapter = ConfereProdutoAdapter(itens)
            confere_produto_recyclerview.layoutManager = LinearLayoutManager(applicationContext)
            confere_produto_recyclerview.adapter = adapter
        })
        mViewModel.preVenda.observe(this,{
            dados_prevenda.codigo_pre_venda.text = it
        })
        mViewModel.cliente.observe(this,{
            dados_prevenda.nome_cliente.text = it
        })
    }
}