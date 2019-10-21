package com.example.deliciasdaju.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pedido(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    val firstName: String?,
    val lastName: String?
){
    constructor():this(null,"","")
}