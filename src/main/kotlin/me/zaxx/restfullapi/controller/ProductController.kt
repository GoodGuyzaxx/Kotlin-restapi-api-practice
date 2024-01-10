package me.zaxx.restfullapi.controller

import me.zaxx.restfullapi.model.CreateProductRequest
import me.zaxx.restfullapi.model.ProductResponse
import me.zaxx.restfullapi.model.UpdateProductRequest
import me.zaxx.restfullapi.model.WebResponse
import me.zaxx.restfullapi.service.ProductService
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json","application/x-www-form-urlencoded"],
        consumes = ["application/json","application/x-www-form-urlencoded","multipart/form-data"],
    )
    fun createProduct(body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
            value = ["/api/products/{id}"]
    )
    fun getProduct(@PathVariable("id") id: String): WebResponse<ProductResponse>{
        val productResponse = productService.get(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @PutMapping(
            value = ["/api/products/{id}"],
            produces = ["application/json","application/x-www-form-urlencoded"],
            consumes = ["application/json","application/x-www-form-urlencoded","multipart/form-data"],
    )
    fun updateProduct(@PathVariable("id") id:String, updateProductRequest: UpdateProductRequest): WebResponse<ProductResponse>{

        val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @DeleteMapping(
            value = ["/api/products/{id}"]
    )
    fun deleteProduct(@PathVariable("id") id: String): WebResponse<String>{
        productService.delete(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = "Data deleted $id"

        )
    }
}