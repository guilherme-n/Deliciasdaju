package com.example.deliciasdaju.model

class Produto(descricao: String, valor: Float){
    var id: Int? = null
    var descricao: String = ""
    var valor: Float = 0f

    init{
        this.descricao = descricao
        this.valor = valor
    }
}