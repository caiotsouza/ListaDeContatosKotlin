package com.example.listadecontatos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listadecontatos.database.ContactDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnAddContact : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAddContact = findViewById(R.id.fab_Add_Contact)

        fun goToNextActivity() {
            val intent = Intent(this, AdicionarContato:: class.java)
            startActivity(intent)
        }

        btnAddContact.setOnClickListener {
            goToNextActivity()
        }
    }

    override fun onStart() {
        super.onStart()

        val contactList = ContactDAO(this).list()
        contactList.forEach {
            Log.i("info_db", "Id: ${it.id} | Nome: ${it.name} | Telefone: ${it.phone} | Email: ${it.email}")
        }
    }
}