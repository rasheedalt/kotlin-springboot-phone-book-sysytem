package com.example.phoneBookSystem.repository

import com.example.phoneBookSystem.model.Contact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository : JpaRepository<Contact, Int> {}