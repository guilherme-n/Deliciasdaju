package com.example.deliciasdaju.ui.historico

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliciasdaju.model.Pedido

class HistoricoViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = Pedido.texto
//    }
//    var text: LiveData<String> = _text

    val text = MutableLiveData<String>()
}