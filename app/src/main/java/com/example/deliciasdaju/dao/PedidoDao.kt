package com.example.deliciasdaju.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.deliciasdaju.model.Pedido

@Dao
interface PedidoDao {
    @Query("Select * from Pedido")
    fun getlAll(): List<Pedido>

    @Insert
    fun insert(pedido: Pedido)

    @Delete
    fun delete(pedido: Pedido)

    //    @Insert
//    fun insertAll(vararg pedidos: Pedido)
}