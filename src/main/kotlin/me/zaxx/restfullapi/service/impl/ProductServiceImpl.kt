package me.zaxx.restfullapi.service.impl

import me.zaxx.restfullapi.entity.Product
import me.zaxx.restfullapi.error.NotFoundException
import me.zaxx.restfullapi.model.CreateProductRequest
import me.zaxx.restfullapi.model.ProductResponse
import me.zaxx.restfullapi.repository.ProductRepository
import me.zaxx.restfullapi.service.ProductService
import me.zaxx.restfullapi.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
): ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity,
            createdAt = Date(),
            updatedAt = null
        )
        productRepository.save(product)

        return convertProductResponse(product)
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)
        if (product == null){
            throw NotFoundException()
        } else{
           return convertProductResponse(product)
        }
    }

    private fun convertProductResponse(product: Product): ProductResponse {
        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
        )
    }

}