package com.example.deliciasdaju.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.deliciasdaju.R
import com.example.deliciasdaju.model.Pedido
import com.example.deliciasdaju.model.Produto
import com.example.deliciasdaju.ui.pedido.PedidoViewModel

class ListProdutoAdapter(private val context: Context, private val fragmento: Fragment) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)
    private var valorTotalParcial: Float = 0f
    private val produtos = mutableListOf<Produto>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewDeliciaItem = inflater.inflate(R.layout.produto_item, parent, false)

        val txtQtdProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtQtdProduto)
        val produto = produtos.get(position)

        val txtDescricaoProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtDescricaoProduto)
        txtDescricaoProduto.setText(produto.descricao)

        val txtValorProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtValorProduto)
        txtValorProduto.setText("R$ %.2f".format(produto.valor))

        val historicoViewModel = ViewModelProviders.of(fragmento).get(PedidoViewModel::class.java)

        val btnRemoverQtd = viewDeliciaItem.findViewById(R.id.btnRemoverQtd) as Button
        btnRemoverQtd.setOnClickListener {
            var qtdAtual: Int = txtQtdProduto.text.toString().toInt()
            if(qtdAtual > 0){
                txtQtdProduto.setText((qtdAtual - 1).toString())
                valorTotalParcial -= produto.valor
                historicoViewModel.totalPedido.value = "R$ %.2f".format(valorTotalParcial)
            }
        }

        val btnAdicionarQtd = viewDeliciaItem.findViewById(R.id.btnAdicionarQtd) as Button
        btnAdicionarQtd.setOnClickListener {
            var qtdAtual: Int = txtQtdProduto.text.toString().toInt()
            if(qtdAtual < 99){
                txtQtdProduto.setText((qtdAtual + 1).toString())
                valorTotalParcial += produto.valor
                historicoViewModel.totalPedido.value = "R$ %.2f".format(valorTotalParcial)
            }
        }

        return viewDeliciaItem
    }

    override fun getCount(): Int {
        return produtos.size
    }

    override fun getItem(position: Int): Any {
        return produtos.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun atualizar(pedidos: List<Produto>){
        this.produtos.clear()
        this.produtos.addAll(pedidos)
        notifyDataSetChanged()
    }

}