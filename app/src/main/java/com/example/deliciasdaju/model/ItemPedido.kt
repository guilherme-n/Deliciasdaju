package com.example.deliciasdaju.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Pedido::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("pedidoId"),
    onUpdate = CASCADE,
    onDelete = CASCADE
)))
data class ItemPedido(
    @PrimaryKey(autoGenerate = true) var id: Long?
    ,val produto: Produto
    ,var quantidade: Int
    ,val pedidoId: Long?)
{
    val valor: Float = produto.valor * quantidade
}