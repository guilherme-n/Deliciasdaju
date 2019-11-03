package com.example.deliciasdaju.ui.pedido

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliciasdaju.dao.ProdutoDao
import com.example.deliciasdaju.model.ItemPedido

class PedidoViewModel(private val produtoDao: ProdutoDao) : ViewModel() {
    val totalPedido = MutableLiveData<Float>()

    val listaItemPedido = MutableLiveData<List<ItemPedido>>()

    init{
        listaItemPedido.value = buscarProdutos()
        totalPedido.value = 0f
    }

    private fun buscarProdutos() : List<ItemPedido>{
        val produtos = produtoDao.getlAll()?.toMutableList()
        produtos?.sortBy { x -> x.descricao }

        val listaItemPedidoLoop = mutableListOf<ItemPedido>()
        produtos?.forEach {
            listaItemPedidoLoop.add( ItemPedido(null, it, 0, null))
        }

        return listaItemPedidoLoop
    }

    fun limparValores(){
        this.totalPedido.value = 0f
        this.listaItemPedido.value = buscarProdutos()
    }
}