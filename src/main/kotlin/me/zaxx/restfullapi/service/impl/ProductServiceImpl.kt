package me.zaxx.restfullapi.service.impl

import me.zaxx.restfullapi.entity.Product
import me.zaxx.restfullapi.error.NotFoundException
import me.zaxx.restfullapi.model.CreateProductRequest
import me.zaxx.restfullapi.model.ListProductRequest
import me.zaxx.restfullapi.model.ProductResponse
import me.zaxx.restfullapi.model.UpdateProductRequest
import me.zaxx.restfullapi.repository.ProductRepository
import me.zaxx.restfullapi.service.ProductService
import me.zaxx.restfullapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import java.util.*
import java.util.stream.Collectors

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
        val product = findProductByIdOrThrowNotFound(id)
           return convertProductResponse(product)
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        validationUtil.validate(updateProductRequest)
        val product = findProductByIdOrThrowNotFound(id)
            product.apply {
                name = updateProductRequest.name!!
                price = updateProductRequest.price!!
                quantity = updateProductRequest.quantity!!
            }
        productRepository.save(product)

        return convertProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products :List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductResponse(it) }
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product{
        val product = productRepository.findByIdOrNull(id)
        if (product == null){
            throw  NotFoundException()
        } else {
            return product
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