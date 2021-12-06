package com.example.pacoteentrega.view.adapter

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pacoteentrega.R
import com.example.pacoteentrega.data.source.remote.models.response.Itens
import kotlinx.android.synthetic.main.lista_conferir_produtos.view.*

 class ConfereProdutoAdapter(val itens: List<Itens>) :
    RecyclerView.Adapter<ConfereProdutoAdapter.ItensViewHolder>() {

    inner class ItensViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itens: Itens) {
            with(itens) {
                itemView.recycler_codigo_produto_itens.text = codigoLido
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItensViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lista_conferir_produtos, parent, false)
        return ItensViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItensViewHolder, position: Int) {
        holder.bind(itens[position])
    }

    override fun getItemCount(): Int {
        return itens.size
    }

 }