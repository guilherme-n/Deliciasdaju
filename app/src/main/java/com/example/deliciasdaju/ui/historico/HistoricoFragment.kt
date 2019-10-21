package com.example.deliciasdaju.ui.historico

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.deliciasdaju.R
import com.example.deliciasdaju.dao.AppDatabase
import com.example.deliciasdaju.ui.adapter.ListPedidoAdapter


class HistoricoFragment : Fragment() {
    private lateinit var viewHistorico: View
    private lateinit var listViewHistorico: ListView
    private var database: AppDatabase? = null
    private lateinit var adapterView: ListPedidoAdapter
    private lateinit var contexto: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewHistorico = inflater.inflate(R.layout.fragment_historico, container, false)
        listViewHistorico = viewHistorico.findViewById(R.id.listViewHistorico)
        contexto = activity ?: FragmentActivity()

        database = AppDatabase.getInstance(contexto)

        adapterView = ListPedidoAdapter(contexto)
        listViewHistorico.adapter = adapterView

        var pedidos = database?.pedidoDao()?.getlAll()
        adapterView.atualizar(pedidos ?: mutableListOf())

        val btnFinalizarPedido = viewHistorico.findViewById(R.id.btnTrocarTexto) as Button
        btnFinalizarPedido.setOnClickListener {
        }

        return viewHistorico
    }

    fun carregarListaHistoricoPedidos() {

    }
}