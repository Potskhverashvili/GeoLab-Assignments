package com.example.contactsbook.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsbook.data.ContactData
import com.example.contactsbook.databinding.ItemContactBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // --------------Properties ------------
    private var contacts = listOf<ContactData>() // list of contacts
    var onDeleteClick: (ContactData) -> Unit = {} // lambda function to delete contact
    var onContactClick: (ContactData) -> Unit = {} // lambda function to click on contact

    // ------------------------------------- Override Methods --------------------------
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])

    }

    override fun getItemCount() = contacts.size


    // ---------------------------------- ViewHolder ----------------------------------
    inner class ContactViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: ContactData) = with(binding) {
            phoneNumberTextView.text = contact.phoneNumber
            contactNameImageView.text = contact.username.first().toString()

            deleteImageView.setOnClickListener {
                onDeleteClick(contact)
            }

            binding.root.setOnClickListener {
                onContactClick(contact)
            }
        }
    }


    // ------------------------------------- Helper Methods -----------------------------

    // ------ Update Contacts ------
    fun updateContacts(newContacts: List<ContactData>) {
        val callBack = ContactCallBack(this.contacts, newContacts)
        val diffResult = DiffUtil.calculateDiff(callBack)

        this.contacts = newContacts
        diffResult.dispatchUpdatesTo(this)
    }


    // ------ Compare old and new contacts ------
    class ContactCallBack(
        private val oldList: List<ContactData>,
        private val newList: List<ContactData>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldContact = oldList[oldItemPosition]
            val newContact = newList[newItemPosition]
            return oldContact.id == newContact.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldContact = oldList[oldItemPosition]
            val newContact = newList[newItemPosition]
            return oldContact == newContact
        }
    }
}