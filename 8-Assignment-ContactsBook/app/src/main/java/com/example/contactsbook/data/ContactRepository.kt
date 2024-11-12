package com.example.contactsbook.data

object ContactRepository {

    //------------ to save contacts --------------
    private val contacts = mutableListOf<Contact>()

    //------------ methods ---------------
    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    fun removeContact(contact: Contact) {
        contacts.remove(contact)
    }

    fun getContacts(): List<Contact> {
        return contacts.toList()
    }
}