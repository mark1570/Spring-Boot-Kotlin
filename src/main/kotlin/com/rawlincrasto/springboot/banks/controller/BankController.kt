package com.rawlincrasto.springboot.banks.controller

import com.rawlincrasto.springboot.banks.model.Bank
import com.rawlincrasto.springboot.banks.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getBanks(): Collection<Bank> {
        return service.getBanks()
    }

    @GetMapping("/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): Bank? {
        return service.getBank(accountNumber)
    }
}