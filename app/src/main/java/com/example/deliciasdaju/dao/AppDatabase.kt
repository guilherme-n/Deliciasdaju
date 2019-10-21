package com.example.deliciasdaju.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deliciasdaju.model.Pedido
import com.example.deliciasdaju.model.Produto


@Database(entities = arrayOf(Pedido::class, Produto::class), version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pedidoDao(): PedidoDao
    abstract fun produtoDao(): ProdutoDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val NOME_BANCO_DADOS = "deliciasdaju.db"

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, NOME_BANCO_DADOS)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}