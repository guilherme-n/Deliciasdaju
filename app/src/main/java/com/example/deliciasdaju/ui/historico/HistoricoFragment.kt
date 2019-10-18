package com.example.deliciasdaju.ui.historico

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.deliciasdaju.R

class HistoricoFragment : Fragment() {

    private lateinit var historicoViewModel: HistoricoViewModel
    private var numero = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historicoViewModel = ViewModelProviders.of(this).get(HistoricoViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_historico, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)

        val observador = Observer<String> {
            textView.text = it
        }

        historicoViewModel.text.observe(this, observador)

        val btnFinalizarPedido = root.findViewById(R.id.btnTrocarTexto) as Button
        btnFinalizarPedido.setOnClickListener {
            historicoViewModel.text.value = numero++.toString()
        }

        return root
    }
}