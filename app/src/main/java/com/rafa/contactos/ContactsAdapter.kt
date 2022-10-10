package com.rafa.contactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafa.contactos.databinding.ContactLayoutBinding

class ContactsAdapter (val contact: List<Contact>, val listener: (Contact) -> Unit): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_layout, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val movie = contact[position]
            holder.bind(movie)

            holder.itemView.setOnClickListener {
                listener(movie)
            }
        }

        override fun getItemCount(): Int = contact.size

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            private val binding = ContactLayoutBinding.bind(view)
            fun bind(contact: Contact){
                binding.name.text = contact.name

                Glide.with(binding.pfp)
                    .load(contact.contactPFP)
                    .into(binding.pfp)
            }
        }
}