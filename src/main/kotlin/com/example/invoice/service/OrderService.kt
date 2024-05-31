package com.example.invoice.service

import com.example.invoice.entity.Order
import com.example.invoice.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService {
    @Autowired
    lateinit var orderrRepository: OrderRepository


    fun list(): List<Order> {
        return orderrRepository.findAll()
    }

    fun getById(id: Long): Order {
        return orderrRepository.findById(id).orElseThrow { RuntimeException("Order not found") }
    }

    fun save(orderr: Order): Order {
        return orderrRepository.save(orderr)
    }

    fun update(id: Long, orderr: Order): Order {
        val existingOrderr = orderrRepository.findById(id).orElseThrow { RuntimeException("Order not found") }
        existingOrderr.status = orderr.status
        existingOrderr.createdAt = orderr.createdAt
        existingOrderr.user = orderr.user

        return orderrRepository.save(existingOrderr)
    }

    fun delete(id: Long) {
        if (orderrRepository.existsById(id)) {
            orderrRepository.deleteById(id)
        } else {
            throw RuntimeException("Order not found")
        }
    }
}