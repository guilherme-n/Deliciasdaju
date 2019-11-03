package com.example.deliciasdaju.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.deliciasdaju.R
import com.example.deliciasdaju.model.ItemPedido
import com.example.deliciasdaju.ui.pedido.PedidoViewModel

class ListProdutoAdapter(private val context: Context, private val fragmento: Fragment) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)
    private val listaItemPedido = mutableListOf<ItemPedido>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewDeliciaItem = inflater.inflate(R.layout.produto_item, parent, false)

        val produto = listaItemPedido.get(position).produto

        val txtQtdProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtQtdProduto)
        txtQtdProduto.text = listaItemPedido.get(position).quantidade.toString()

        val txtDescricaoProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtDescricaoProduto)
        txtDescricaoProduto.setText(produto.descricao)

        val txtValorProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtValorProduto)
        txtValorProduto.setText("R$ %.2f".format(produto.valor))

        val pedidoViewModel = ViewModelProviders.of(fragmento).get(PedidoViewModel::class.java)

        val itemPedido = pedidoViewModel.listaItemPedido

        val btnRemoverQtd = viewDeliciaItem.findViewById(R.id.btnRemoverQtd) as Button
        btnRemoverQtd.setOnClickListener {
            val qtdAtual: Int? = itemPedido.value?.get(position)?.quantidade
            if(qtdAtual != null && qtdAtual > 0){
                itemPedido.value?.get(position)?.quantidade = qtdAtual - 1

                pedidoViewModel.totalPedido.value = pedidoViewModel.totalPedido.value!! - produto.valor
                notifyDataSetChanged()
            }
        }

        val btnAdicionarQtd = viewDeliciaItem.findViewById(R.id.btnAdicionarQtd) as Button
        btnAdicionarQtd.setOnClickListener {
            val qtdAtual: Int? = itemPedido.value?.get(position)?.quantidade
            if(qtdAtual != null && qtdAtual < 99){
                itemPedido.value?.get(position)?.quantidade = qtdAtual + 1
                pedidoViewModel.totalPedido.value = pedidoViewModel.totalPedido.value!! + produto.valor
                notifyDataSetChanged()
            }
        }

        return viewDeliciaItem
    }

    override fun getCount(): Int {
        return listaItemPedido.size
    }

    override fun getItem(position: Int): Any {
        return listaItemPedido.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun atualizar(pedidos: List<ItemPedido>){
        this.listaItemPedido.clear()
        this.listaItemPedido.addAll(pedidos)
        notifyDataSetChanged()
    }

}