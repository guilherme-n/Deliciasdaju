package com.example.deliciasdaju.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.deliciasdaju.model.Produto

@Dao
interface ProdutoDao {
    @Query("Select * from Produto")
    fun getlAll(): List<Produto>

    @Insert
    fun insert(produto: Produto)

    @Insert
    fun insertAll(produtos: List<Produto>)

//    @Delete
//    fun delete(produto: Produto)
}