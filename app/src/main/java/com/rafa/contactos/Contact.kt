package com.rafa.contactos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(val name: String, val phone: String, val mail: String, val contactPFP: String): Parcelable {
}