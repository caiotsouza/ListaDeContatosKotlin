package com.example.listadecontatos.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.listadecontatos.model.Contact

class ContactDAO(context: Context) : iContact {

    val write = DataBaseHelper(context).writableDatabase
    val read = DataBaseHelper(context).readableDatabase

    override fun save(contact: Contact): Boolean {
        val content = ContentValues()
        content.put("name", contact.name)
        content.put("phone", contact.phone)
        content.put("email", contact.email)

        try {
            write.insert("contacts", null, content)
            Log.i("info_db", "Registro realizado com sucesso")
        } catch (e: Exception) {
            Log.i("info_db", "Erro ao registrar no banco")
            return false
        }
        return true
    }

    override fun delete(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun edit(contact: Contact): Boolean {
        TODO("Not yet implemented")
    }

    override fun list(): List<Contact> {
        val contactList = mutableListOf<Contact>()
        val sql = "SELECT * FROM contacts"
        val cursor = read.rawQuery(sql, null)
        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))

            val contact = Contact(id, name, phone, email)
            contactList.add(contact)
        }
        return contactList
    }

}