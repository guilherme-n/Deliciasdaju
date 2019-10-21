package com.example.deliciasdaju.ui.pedido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.deliciasdaju.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.deliciasdaju.dao.AppDatabase
import com.example.deliciasdaju.model.Pedido
import com.example.deliciasdaju.model.Produto
import com.example.deliciasdaju.ui.adapter.ListProdutoAdapter


class PedidoFragment : Fragment() {
    private lateinit var viewPedido: View
    private var database: AppDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewPedido = inflater.inflate(R.layout.fragment_pedido, container, false)

        database = AppDatabase.getInstance(activity?: FragmentActivity())

        val listView : ListView = viewPedido.findViewById(R.id.listViewPedido)
        val txtTotalPedido = viewPedido.findViewById(R.id.txtTotalPedido) as TextView
        val pedidoViewModel = ViewModelProviders.of(this).get(PedidoViewModel::class.java)
        pedidoViewModel.totalPedido.value = "R$ 0,00"

        val arrayAdapter = ListProdutoAdapter(activity?: FragmentActivity(), this)
        listView.adapter = arrayAdapter

//        popularBancoComProdutos(listView)

        val produtos = database?.produtoDao()?.getlAll()?.toMutableList()
        produtos?.sortBy { x -> x.descricao }
        arrayAdapter.atualizar(produtos ?: mutableListOf())


        val observador = Observer<String> {
            txtTotalPedido.text = it
        }

        pedidoViewModel.totalPedido.observe(this, observador)

        cadastrarEventos()

        return viewPedido
    }

    private fun cadastrarEventos(){

        val btnFinalizarPedido = viewPedido.findViewById(R.id.btnFinalizarPedido) as Button
        btnFinalizarPedido.setOnClickListener {
            val pedido = Pedido( null,"Nome2", "Sobrenome2")
            cadastrarPedido(pedido)

            Toast.makeText(activity, "Pedido finalizado", Toast.LENGTH_LONG).show()
        }
    }

    private fun cadastrarPedido(pedido: Pedido){
        database?.pedidoDao()?.insert(pedido)
    }

    private fun popularBancoComProdutos(listView: ListView){

        val listaProdutos = mutableListOf<Produto>()
        listaProdutos.add(Produto(null, "Cachorro quente", 3f))
        listaProdutos.add(Produto(null, "Tortinha", 1f))
        listaProdutos.add(Produto(null, "Delicia de abacaxi", 2.5f))
        listaProdutos.add(Produto(null, "Pave", 2.5f))
        listaProdutos.add(Produto(null, "Hamburguer", 3f))
        listaProdutos.add(Produto(null, "Sanduiche natural", 3f))

        database?.produtoDao()?.insertAll(listaProdutos)
    }

}