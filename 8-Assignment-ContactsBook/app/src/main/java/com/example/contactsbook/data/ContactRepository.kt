package com.example.contactsbook.data

object ContactRepository {

    //------------ to save contacts --------------
    private val contacts = mutableListOf<ContactData>()

    //------------ methods ---------------
    fun addContact(contact: ContactData) {
        contacts.add(contact)
    }

    fun removeContact(contact: ContactData) {
        contacts.remove(contact)
    }

    fun getContacts(): List<ContactData> {
        return contacts.toList()
    }
}