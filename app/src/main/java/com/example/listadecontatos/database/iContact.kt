package com.example.listadecontatos.database

import com.example.listadecontatos.model.Contact

interface iContact {
    fun save (contact: Contact) : Boolean
    fun delete (id: Int) : Boolean
    fun edit (contact: Contact) : Boolean
    fun list() : List<Contact>
}
