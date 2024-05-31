package com.example.invoice.controller

import com.example.invoice.entity.User
import com.example.invoice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    lateinit var userrService: UserService

    @GetMapping
    fun list(): List<User> {
        return userrService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): User {
        return userrService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody userr: User): User {
        return userrService.save(userr)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody userr: User): User {
        return userrService.update(id, userr)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        userrService.delete(id)
        return "User with id $id deleted successfully"
    }
}