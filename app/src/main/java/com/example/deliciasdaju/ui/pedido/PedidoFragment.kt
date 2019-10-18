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
import com.example.deliciasdaju.model.ItemPedido
import com.example.deliciasdaju.model.Produto
import com.example.deliciasdaju.ui.adapter.ListaItemPedidoAdapter
import com.example.deliciasdaju.ui.historico.HistoricoViewModel


class PedidoFragment : Fragment() {
    private lateinit var viewPedido: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewPedido = inflater.inflate(R.layout.fragment_pedido, container, false)

        val listView : ListView = viewPedido.findViewById(R.id.listViewPedido)
        val txtTotalPedido = viewPedido.findViewById(R.id.txtTotalPedido) as TextView
        val pedidoViewModel = ViewModelProviders.of(this).get(PedidoViewModel::class.java)
        pedidoViewModel.totalPedido.value = "R$ 0,00"

        val listaProdutos = mutableListOf<Produto>()
        listaProdutos.add(Produto("Cachorro quente", 3f))
        listaProdutos.add(Produto("Tortinha", 1f))
        listaProdutos.add(Produto("Delicia de abacaxi", 2.5f))
        listaProdutos.add(Produto("Pave", 2.5f))
        listaProdutos.add(Produto("Hamburguer", 3f))

        val arrayAdapter = ListaItemPedidoAdapter(activity?: FragmentActivity(), listaProdutos, this)
        listView.adapter = arrayAdapter

        val observador = Observer<String> {
            txtTotalPedido.text = it
        }

        pedidoViewModel.totalPedido.observe(this, observador)

//        adicionarEventos()

        return viewPedido
    }

    private fun adicionarEventos(){

        val btnFinalizarPedido = viewPedido.findViewById(R.id.btnFinalizarPedido) as Button
        btnFinalizarPedido.setOnClickListener {
            val txtTotalPedido = viewPedido.findViewById(R.id.txtTotalPedido) as TextView
            txtTotalPedido.text = "teste"
            Toast.makeText(activity, "valor alterado", Toast.LENGTH_LONG).show()
        }
    }
}