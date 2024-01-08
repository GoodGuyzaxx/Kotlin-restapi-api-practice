package me.zaxx.restfullapi.service

import me.zaxx.restfullapi.model.CreateProductRequest
import me.zaxx.restfullapi.model.ProductResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse
}