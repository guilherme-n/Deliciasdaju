package com.example.deliciasdaju.model

data class ItemPedido(val produto: Produto, var quantidade: Int) {
    var id: Long = 0
    val valor: Float = produto.valor * quantidade
}