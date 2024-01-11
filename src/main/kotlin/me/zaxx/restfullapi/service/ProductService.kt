package me.zaxx.restfullapi.service

import me.zaxx.restfullapi.model.CreateProductRequest
import me.zaxx.restfullapi.model.ListProductRequest
import me.zaxx.restfullapi.model.ProductResponse
import me.zaxx.restfullapi.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id : String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

}