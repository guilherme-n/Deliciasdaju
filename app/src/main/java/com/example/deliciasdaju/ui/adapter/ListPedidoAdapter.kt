package com.example.deliciasdaju.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.deliciasdaju.R
import com.example.deliciasdaju.model.Pedido
import com.example.deliciasdaju.model.Produto

class ListPedidoAdapter(private val context: Context) : BaseAdapter(){
    private val inflater = LayoutInflater.from(context)
    private val pedidos = mutableListOf<Pedido>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewPedidoItem = inflater.inflate(R.layout.pedido_item, parent, false)

        val txtDescricaoPedido = viewPedidoItem.findViewById<TextView>(R.id.txtDescricaoPedido)
        txtDescricaoPedido.text = pedidos.get(position).id.toString()

        return viewPedidoItem
    }

    override fun getItem(position: Int): Any {
        return pedidos.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return pedidos.size
    }

    fun atualizar(pedidos: List<Pedido>){
        this.pedidos.clear()
        this.pedidos.addAll(pedidos)
        notifyDataSetChanged()
    }
}