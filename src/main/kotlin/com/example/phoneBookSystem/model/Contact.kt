package com.example.phoneBookSystem.model

import javax.persistence.*

@Entity
@Table(name = "contacts" )
 data class Contact(
         val name: String,
         val phoneNumber: Long,
         val address: String,
         @Id @GeneratedValue val id: Int? = null
)