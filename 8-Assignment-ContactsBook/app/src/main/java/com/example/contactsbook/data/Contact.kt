package com.example.contactsbook.data

import java.util.UUID

data class Contact(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    val phoneNumber: String,
)
