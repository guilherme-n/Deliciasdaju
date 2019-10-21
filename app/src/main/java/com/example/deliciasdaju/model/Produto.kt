package com.example.deliciasdaju.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Produto(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    val descricao: String,
    val valor: Float
){
    constructor():this(null,"",0f)
}