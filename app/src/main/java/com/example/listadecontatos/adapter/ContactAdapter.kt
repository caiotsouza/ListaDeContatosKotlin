package com.example.listadecontatos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecontatos.R
import com.example.listadecontatos.model.Contact

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private var contactList : List<Contact> = emptyList()

    fun setContactList(contactList: List<Contact>){
        this.contactList = contactList
        notifyDataSetChanged()
    }
    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val contactName = itemView.findViewById<TextView>(R.id.Contact_Name)
        val contactEmail = itemView.findViewById<TextView>(R.id.Contact_Email)
        val contactPhone = itemView.findViewById<TextView>(R.id.Contact_Phone)
        val btnEdit = itemView.findViewById<ImageButton>(R.id.btn_Edit)
        val btnDelete = itemView.findViewById<ImageButton>(R.id.btn_Delete)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
        val contact = contactList[position]
        val name = contact.name
        val email = contact.email
        val phone = contact.phone

        holder.itemView.findViewById<TextView>(R.id.Contact_Name)
        holder.itemView.findViewById<TextView>(R.id.Contact_Email)
        holder.itemView.findViewById<TextView>(R.id.Contact_Phone)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

}
