package com.fazahidah.dodolan.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id: Int,
    val name: String,
    val username: String,
    val password: String,
    val email: String,
    val balance: Int = 0,
    val debt: Int = 0
)

// TODO: update class name
@Entity(tableName = "table_penghutang")
data class Penghutang(
    // used for history transactions
    @PrimaryKey
    val id: Int,
    // takes from table_user
    @ForeignKey(
        entity = User::class,
        parentColumns = ["user_id"],
        childColumns = ["user_id"]
    )
    val user_id: Int,
    val name: String,
    val amount: Int
)

@Entity(tableName = "table_product")
data class Product(
    // used for product id
    @PrimaryKey
    val id: Int,
    // takes from User data class -> user_id,
    // used for product owner
    @ForeignKey(
        entity = User::class,
        parentColumns = ["user_id"],
        childColumns = ["user_id"]
    )
    val user_id: Int,
    val name: String,
    val price: Int
)