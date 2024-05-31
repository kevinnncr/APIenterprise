package com.example.invoice.controller

import com.example.invoice.entity.Order
import com.example.invoice.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController {
    @Autowired
    lateinit var orderrService: OrderService

    @GetMapping
    fun list(): List<Order> {
        return orderrService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Order {
        return orderrService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody orderr: Order): Order {
        return orderrService.save(orderr)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody orderr: Order): Order {
        return orderrService.update(id, orderr)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        orderrService.delete(id)
        return "Order with id $id deleted successfully"
    }
}