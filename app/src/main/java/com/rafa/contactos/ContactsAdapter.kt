package com.rafa.contactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafa.contactos.databinding.ContactLayoutBinding

class ContactsAdapter (val contactList:List<Contact>, val listener: (Contact) -> Unit): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(contactList[position])
            holder.itemView.setOnClickListener{
            listener(contactList[position])
            }
        }

        override fun getItemCount(): Int = contactList.size

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            private val binding = ContactLayoutBinding.bind(view)
            fun bind(contact: Contact){
                binding.name.text = contact.name
                binding.phone.text = contact.phone
                binding.mail.text = contact.mail
                Glide.with(binding.pfp)
                    .load(contact.contactPFP)
                    .into(binding.pfp)
            }
        }
}