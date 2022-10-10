package com.rafa.contactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.rafa.contactos.databinding.ActivityMainBinding

class MainActivity : Fragment(R.layout.activity_main){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ActivityMainBinding.bind(view).apply {
            recycler.adapter = ContactsAdapter(contacts){ contact -> navigateTo(contact)
            }
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
    }

    private fun navigateTo(contact: Contact) {
        parentFragmentManager.commit {
            setCustomAnimations(R.anim.slide_right_in,
                R.anim.slide_left_out,
                R.anim.slide_left_in,
                R.anim.slide_right_out)
            replace(R.id.fragment_container_view_tag, ContactInfo.create(contact))
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}

private val contacts = (1..100).map { Contact(
        "Contacto $it",
        "Número: $it",
        "Mail: $it",
        "https://loremflickr.com/240/320/paris?lock=$it")
}