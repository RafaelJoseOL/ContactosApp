package com.rafa.contactos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : Fragment(R.layout.activity_main){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = ContactsAdapter(movies){ contact -> navigateTo(contact)
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
            replace(R.id.fragment_container_view, DetailFragment.create(movie))
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}

private val movies = (1..100).map {Contact(
        "Contacto $it",
        "https://loremflickr.com/240/320/paris?lock=$it")
}