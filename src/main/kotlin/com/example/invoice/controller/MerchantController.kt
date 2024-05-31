package com.example.invoice.controller

import com.example.invoice.entity.Merchant
import com.example.invoice.service.MerchantService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/merchants")
class MerchantController {
    @Autowired
    lateinit var merchantService: MerchantService

    @GetMapping
    fun list(): List<Merchant> {
        return merchantService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Merchant {
        return merchantService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody merchant: Merchant): Merchant {
        return merchantService.save(merchant)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody merchant: Merchant): Merchant {
        return merchantService.update(id, merchant)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        merchantService.delete(id)
        return "Merchant with id $id deleted successfully"
    }
}