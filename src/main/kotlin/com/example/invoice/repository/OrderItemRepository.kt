package com.example.invoice.repository

import com.example.invoice.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderItemRepository: JpaRepository <OrderItem, Long?> {

}