package com.example.deliciasdaju.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.deliciasdaju.R
import com.example.deliciasdaju.model.Produto
import com.example.deliciasdaju.ui.pedido.PedidoViewModel

class ListaItemPedidoAdapter(private val context: Context, private val produtos: List<Produto>, private val fragmento: Fragment) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)
    private var valorTotalParcial: Float = 0f

    override fun getCount(): Int {
        return produtos.size
    }

    override fun getItem(position: Int): Any {
        return produtos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewDeliciaItem = inflater.inflate(R.layout.delicia_item, parent, false)

        val txtQtdProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtQtdProduto)

        val txtDescricaoProduto = viewDeliciaItem.findViewById<TextView>(R.id.txtDescricaoProduto)
        txtDescricaoProduto.setText(produtos[position].descricao)

        val historicoViewModel = ViewModelProviders.of(fragmento).get(PedidoViewModel::class.java)

        val btnRemoverQtd = viewDeliciaItem.findViewById(R.id.btnRemoverQtd) as Button
        btnRemoverQtd.setOnClickListener {
            var qtdAtual: Int = txtQtdProduto.text.toString().toInt()
            if(qtdAtual > 0){
                txtQtdProduto.setText((qtdAtual - 1).toString())
                valorTotalParcial -= produtos[position].valor
                historicoViewModel.totalPedido.value = "R$ %.2f".format(valorTotalParcial)
            }
        }

        val btnAdicionarQtd = viewDeliciaItem.findViewById(R.id.btnAdicionarQtd) as Button
        btnAdicionarQtd.setOnClickListener {
            var qtdAtual: Int = txtQtdProduto.text.toString().toInt()
            if(qtdAtual < 99){
                txtQtdProduto.setText((qtdAtual + 1).toString())
                valorTotalParcial += produtos[position].valor
                historicoViewModel.totalPedido.value = "R$ %.2f".format(valorTotalParcial)
            }
        }

        return viewDeliciaItem
    }

}