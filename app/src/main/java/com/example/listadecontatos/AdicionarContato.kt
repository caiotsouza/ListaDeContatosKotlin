package com.example.listadecontatos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listadecontatos.database.ContactDAO
import com.example.listadecontatos.model.Contact

class AdicionarContato : AppCompatActivity() {
    private lateinit var btnAddContact : Button
    private lateinit var btnCancel : Button
    private lateinit var editNameContact : EditText
    private lateinit var editPhoneContact : EditText
    private lateinit var editEmailContact : EditText

    fun createContact(contactNameInput: String, contactPhoneInput: String, contactEmailInput: String) {
        val newContact = Contact(-1, contactNameInput, contactPhoneInput, contactEmailInput)
        val contactDAO = ContactDAO(this)

        if(contactDAO.save(newContact)) {
            Toast.makeText(this, "Contato adicionado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Erro ao adicionar contato", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adicionar_contato)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAddContact = findViewById(R.id.btn_Add_Contact)
        btnCancel = findViewById(R.id.btn_Cancel)
        editNameContact = findViewById(R.id.edit_Name)
        editPhoneContact = findViewById(R.id.edit_Phone)
        editEmailContact = findViewById(R.id.edit_Email)



        btnAddContact.setOnClickListener {
            if( editNameContact.text.toString().isNotEmpty() &&
                editPhoneContact.text.toString().isNotEmpty() &&
                editEmailContact.text.toString().isNotEmpty()
            ) {

                val contactNameInput = editNameContact.text.toString()
                val contactPhoneInput = editPhoneContact.text.toString()
                val contactEmailInput = editEmailContact.text.toString()

                createContact(contactNameInput, contactPhoneInput, contactEmailInput)
            } else {
                Toast.makeText(this, "Insira um valor válido para adicionar seu contato", Toast.LENGTH_SHORT).show()
            }
        }
        btnCancel.setOnClickListener {
            finish()
        }
    }
}