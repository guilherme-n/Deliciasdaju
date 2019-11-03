package com.example.deliciasdaju.ui.pedido

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.deliciasdaju.dao.ProdutoDao

class PedidoViewModelFactory(private val repository: ProdutoDao) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PedidoViewModel(repository) as T
    }
}