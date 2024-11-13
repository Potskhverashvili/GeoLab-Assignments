package com.example.contactsbook.data

import java.util.UUID

data class ContactData(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    val phoneNumber: String,
)
