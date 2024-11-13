package com.example.contactsbook.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsbook.data.ContactData
import com.example.contactsbook.data.ContactRepository
import com.example.contactsbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val contactListAdapter = ContactListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()
        setListeners()
    }


    // ------------------------------------- Helper Methods -------------------------------------

    // ------ Init RecyclerView ------
    private fun initRecyclerView() {
        binding.contactsRecyclerView.adapter = contactListAdapter
    }

    // ------ Set Listener ------
    private fun setListeners() = with(binding) {
        addButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateContact::class.java)
            startActivity(intent)
        }

        contactListAdapter.onDeleteClick = { contact ->
            ContactRepository.removeContact(contact)
            updateContacts()
        }

        contactListAdapter.onContactClick = { contact ->
            alertDialog(contact)
        }
    }

    // ------ Update Contacts ------
    private fun updateContacts() {
        contactListAdapter.submitList(ContactRepository.getContacts())
    }

    // ------ Alert Dialog ------
    private fun alertDialog(contact: ContactData) {
        AlertDialog.Builder(this)
            .setTitle("Contact Details")
            .setMessage("Name: ${contact.username}\nPhone Number: ${contact.phoneNumber}")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    // ---- onRestart Method ------
    override fun onRestart() {
        super.onRestart()
        d("MainActivity", "MainActivity - onRestart")
        updateContacts()
    }
}
