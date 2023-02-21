package com.example.phoneBookSystem.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiResponse {
  companion object {
      fun validResponse(data: Any, message: String?): ResponseEntity<Any> {
          val res: MutableMap<String, Any> = HashMap()
          res["success"] = true
          res["message"] = message ?: "success"
          res["status"] = 200
          res["data"] = data
          return ResponseEntity<Any>(res, HttpStatus.OK)
      }

      fun errorResponse(status: HttpStatus, data: Any?, message: String ): ResponseEntity<Any> {
          val res: MutableMap<String, Any> = HashMap()
          res["success"] = false
          res["message"] = message
          res["status"] = status.value()
          res["data"] = data as Any
          return ResponseEntity(res, status)
      }
  }
}