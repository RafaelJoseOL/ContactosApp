package com.rafa.contactos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.rafa.contactos.databinding.ActivityMainBinding
import android.content.Intent

class MainActivity : Fragment(R.layout.activity_main){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = ActivityMainBinding.bind(view).apply {
            recycler.adapter = ContactsAdapter(contacts){ contact -> navigateTo(contact)
            }
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.app_name)
    }

    private val pfp = "https://loremflickr.com/g/240/320/person";
    private val contacts =
        listOf(
            Contact("Juan", "654789321", "correo1@gmail.com", pfp),
            Contact("Fran", "654123987", "correo2@gmail.com", pfp),
            Contact("Ismael", "698741235", "email@gmail.com", pfp),
        )

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
