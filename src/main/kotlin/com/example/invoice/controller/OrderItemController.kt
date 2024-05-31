package com.example.invoice.controller

import com.example.invoice.entity.OrderItem
import com.example.invoice.service.OrderItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orderitems")
class OrderItemController {
    @Autowired
    lateinit var orderItemService: OrderItemService

    @GetMapping
    fun list(): List<OrderItem> {
        return orderItemService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): OrderItem {
        return orderItemService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody orderItem: OrderItem): OrderItem {
        return orderItemService.save(orderItem)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody orderItem: OrderItem): OrderItem {
        return orderItemService.update(id, orderItem)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        orderItemService.delete(id)
        return "OrderItem with id $id deleted successfully"
    }
}