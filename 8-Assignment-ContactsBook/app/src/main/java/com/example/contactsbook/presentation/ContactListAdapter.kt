package com.example.contactsbook.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsbook.data.ContactData
import com.example.contactsbook.databinding.ItemContactBinding

class ContactListAdapter :
    ListAdapter<ContactData, ContactListAdapter.ContactViewHolder>(UserDiffUtil()) {

    var onDeleteClick: (ContactData) -> Unit = {} // lambda function to delete contact
    var onContactClick: (ContactData) -> Unit = {} // lambda function to click on contact


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
        holder.bind(getItem(position))
    }


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


    class UserDiffUtil : DiffUtil.ItemCallback<ContactData>() {
        override fun areItemsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ContactData, newItem: ContactData): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }
}