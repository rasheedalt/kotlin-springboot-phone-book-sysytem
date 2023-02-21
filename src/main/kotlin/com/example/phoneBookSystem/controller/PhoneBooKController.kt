package com.example.phoneBookSystem.controller

import com.example.phoneBookSystem.dto.ApiResponse.Companion.errorResponse
import com.example.phoneBookSystem.dto.ApiResponse.Companion.validResponse
import com.example.phoneBookSystem.model.Contact
import com.example.phoneBookSystem.repository.ContactRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/phone-book")
class PhoneBooKController(val contactRepository: ContactRepository) {

    @PostMapping("/create")
    fun createContact(@RequestBody contact: Contact): ResponseEntity<Any> {
        return try {
            var contact = contactRepository.save(contact);
            validResponse(contact, "Contact created successfully")
        }catch (e: Exception){
            errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, e.localizedMessage)
        }
    }

    @GetMapping("")
    fun allContacts(): ResponseEntity<Any> {
        return try {
            var contacts = contactRepository.findAll()
            validResponse(contacts, null)
        }catch (e: Exception){
            errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, e.localizedMessage)
        }

    }


    @GetMapping("/{id}")
    fun getContact(@PathVariable id: Int): ResponseEntity<Any> {
        return try {
            var contact = contactRepository.findById(id);
            validResponse(contact, null)
        }catch (e: Exception){
            errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, e.localizedMessage)
        }
    }

    @DeleteMapping("/delete/{id}")
    fun deleteContact(@PathVariable id: Int): ResponseEntity<Any> {
        return try {
            var contact = contactRepository.deleteById(id);
            validResponse(contact, "Contact deleted successfully")
        }catch (e: Exception){
            errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, e.localizedMessage)
        }
    }
}