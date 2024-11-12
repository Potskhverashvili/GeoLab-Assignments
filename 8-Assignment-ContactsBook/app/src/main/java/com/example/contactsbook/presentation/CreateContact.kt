package com.example.contactsbook.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsbook.data.Contact
import com.example.contactsbook.data.ContactRepository
import com.example.contactsbook.databinding.ActivityCreateContactBinding

class CreateContact : AppCompatActivity() {

    private val binding by lazy { ActivityCreateContactBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListener()
    }

    // -------------- Set Listener Method -----------------
    private fun setListener() = with(binding) {
        createButton.setOnClickListener {
            // get username and phone number
            val username = usernameEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val toAddContact = Contact(username = username, phoneNumber = phoneNumber)

            // check if fields are empty
            if (username.isEmpty() || phoneNumber.isEmpty()) {
                Toast.makeText(this@CreateContact, "Please fill all fields", Toast.LENGTH_SHORT)
                    .show().also { return@setOnClickListener }
            }

            // add contact to list
            ContactRepository.addContact(toAddContact)
            Toast.makeText(this@CreateContact, "Contact added", Toast.LENGTH_SHORT).show()


            // go back to main activity
            finish()
        }
    }
}
