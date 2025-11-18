package com.example.listadecontatos.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseHelper(context: Context) : SQLiteOpenHelper(
    context,
    "contacts",
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql =  "CREATE TABLE IF NOT EXISTS Contact(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR(100) NOT NULL," +
                "phone VARCHAR(100) NOT NULL," +
                "email VARCHAR(100) NOT NULL);"
        try {
            db?.execSQL(sql)
            Log.i("info_db", "Banco criado com sucesso")
        } catch (e: Exception) {
            Log.i("info_db", "Erro ao criar o banco")
        }
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}
