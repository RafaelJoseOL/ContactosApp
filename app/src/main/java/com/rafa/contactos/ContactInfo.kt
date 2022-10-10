package com.rafa.contactos

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.rafa.contactos.databinding.ContactInfoBinding

class ContactInfo : Fragment(R.layout.contact_info) {

    companion object{
        const val EXTRA_CONTACT = "DetailActivity:Contact"

        fun create(contact: Contact): ContactInfo = ContactInfo().apply {
                arguments = bundleOf(EXTRA_CONTACT to contact)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ContactInfoBinding.bind(view)

        val contact = arguments?.getParcelable<Contact>(EXTRA_CONTACT)

        if (contact != null) {
            (requireActivity() as AppCompatActivity).supportActionBar?.title = contact.name
            Glide.with(binding.imagen)
                .load(contact.contactPFP)
                .into(binding.imagen)
        }
    }
}