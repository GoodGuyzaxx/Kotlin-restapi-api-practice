package me.zaxx.restfullapi.repository

import me.zaxx.restfullapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, String> {

}