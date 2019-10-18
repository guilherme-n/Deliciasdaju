package com.example.deliciasdaju.model

class ItemPedido(produto: Produto) {
    var id: Long = 0
    var produto: Produto
    var quantidade: Int = 0
    val valor: Float = produto.valor * quantidade

    init {
        this.produto = produto
    }

    override fun toString(): String{
        return produto.descricao
    }
}