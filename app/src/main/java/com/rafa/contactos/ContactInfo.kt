package com.rafa.contactos

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.rafa.contactos.databinding.ContactInfoBinding

class ContactInfo : Fragment(R.layout.contact_info) {

    companion object {
        const val EXTRA_CONTACT = "contact"

        fun create(contact: Contact): ContactInfo = ContactInfo().apply {
            arguments = bundleOf(EXTRA_CONTACT to contact)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ContactInfoBinding.bind(view)

        val contact = arguments?.getParcelable<Contact>(EXTRA_CONTACT)
        if (contact != null) {
            binding.textName.text = contact.name;
            Glide.with(binding.pfp)
                .load(contact.contactPFP)
                .into(binding.pfp)
        }
        binding.callButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact?.phone))
            startActivity(intent);
        }

        binding.emailButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO);
            intent.data = Uri.parse("mailto:" + contact?.mail)
            startActivity(intent);
        }
    }
}