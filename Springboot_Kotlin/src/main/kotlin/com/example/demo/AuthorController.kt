package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController {

    @GetMapping("/")
    fun showData() : MutableList<String> {
        val authors = mutableListOf<String>(
                "Haruki Murakami",
                "Jane Austin",
                "Ernest Hemingway"
        )
        return authors
    }
}