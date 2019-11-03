package com.example.deliciasdaju.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.deliciasdaju.Util.DateConverter
import java.util.*
import kotlin.collections.ArrayList

@Entity
data class Pedido(
    @PrimaryKey(autoGenerate = true) var id: Long?
//    @TypeConverters(DateConverter::class) val data: Date?
//    val listaItemPedido: ArrayList<ItemPedido>
){
    constructor():this(null)
}