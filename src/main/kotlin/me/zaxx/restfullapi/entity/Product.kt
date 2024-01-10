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
    var name : String,

    @Column(name = "price")
    var price : Long,

    @Column(name = "quantity")
    var quantity : Int,

    @Column(name = "created_at")
    val createdAt : Date,

    @Column(name = "updated_at")
    val updatedAt : Date?
)
