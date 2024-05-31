package com.example.invoice.service

import com.example.invoice.entity.OrderItem
import com.example.invoice.repository.OrderItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderItemService {
    @Autowired
    lateinit var orderItemRepository: OrderItemRepository

    fun list(): List<OrderItem> {
        return orderItemRepository.findAll()
    }

    fun getById(id: Long): OrderItem {
        return orderItemRepository.findById(id).orElseThrow { RuntimeException("OrderItem not found") }
    }

    fun save(orderItem: OrderItem): OrderItem {
        return orderItemRepository.save(orderItem)
    }

    fun update(id: Long, orderItem: OrderItem): OrderItem {
        val existingOrderItem = orderItemRepository.findById(id).orElseThrow { RuntimeException("OrderItem not found") }
        existingOrderItem.quantity = orderItem.quantity
        existingOrderItem.order = orderItem.order
        existingOrderItem.product = orderItem.product

        return orderItemRepository.save(existingOrderItem)
    }

    fun delete(id: Long) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id)
        } else {
            throw RuntimeException("OrderItem not found")
        }
    }
}