package me.zaxx.restfullapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "Products")
data class Product(

    @Id
    val id : String,

    @Column(name = "name")
    val name : String,

    @Column(name = "price")
    val price : Long,

    @Column(name = "quantity")
    val quantity : Int,

    @Column(name = "created_at")
    val createdAt : Date,

    @Column(name = "updated_at")
    val updatedAt : Date?
)