package com.example.invoice.service

import com.example.invoice.entity.Product
import com.example.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository

    fun list(): List<Product> {
        return productRepository.findAll()
    }

    fun getById(id: Long): Product {
        return productRepository.findById(id).orElseThrow { RuntimeException("Product not found") }
    }

    fun save(product: Product): Product {
        return productRepository.save(product)
    }

    fun update(id: Long, product: Product): Product {
        val existingProduct = productRepository.findById(id).orElseThrow { RuntimeException("Product not found") }
        existingProduct.description = product.description
        existingProduct.merchant = product.merchant
        existingProduct.price = product.price
        existingProduct.status = product.status
        existingProduct.createdAt = product.createdAt

        return productRepository.save(existingProduct)
    }

    fun delete(id: Long) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id)
        } else {
            throw RuntimeException("Product not found")
        }
    }
}