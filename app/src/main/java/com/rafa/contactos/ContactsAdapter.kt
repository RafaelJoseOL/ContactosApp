package com.rafa.contactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactsAdapter (val movies: List<Contact>, val listener: (Contact) -> Unit): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.contacts_view, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val movie = movies[position]
            holder.bind(movie)

            holder.itemView.setOnClickListener {
                listener(movie)
            }
        }

        override fun getItemCount(): Int = movies.size

        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            private val binding = ViewMovieBinding.bind(view)
            fun bind(contact: Contact){
                binding.title.text = contact.name

                Glide.with(binding.imagen)
                    .load(contact.contactPFP)
                    .into(binding.imagen)
            }
        }
}