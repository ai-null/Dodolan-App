package com.fazahidah.dodolan.model

data class User(
    val name: String,
    val username: String,
    val password: String,
    val email: String,
    val balance: Int,
    val debt: Int
)

data class Product(
    val owner: String,
    val name: String,
    val price: Int
)