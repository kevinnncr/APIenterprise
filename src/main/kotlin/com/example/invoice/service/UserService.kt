package com.example.invoice.service

import com.example.invoice.entity.User
import com.example.invoice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userrRepository: UserRepository

    fun list(): List<User> {
        return userrRepository.findAll()
    }

    fun getById(id: Long): User {
        return userrRepository.findById(id).orElseThrow { RuntimeException("User not found") }
    }

    fun save(userr: User): User {
        return userrRepository.save(userr)
    }

    fun update(id: Long, userr: User): User {
        val existingUserr = userrRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        existingUserr.fullname = userr.fullname
        existingUserr.email = userr.email
        existingUserr.gender = userr.gender
        existingUserr.dateOfBirth = userr.dateOfBirth
        existingUserr.createdAt = userr.createdAt
        existingUserr.country = userr.country

        return userrRepository.save(existingUserr)
    }

    fun delete(id: Long) {
        if (userrRepository.existsById(id)) {
            userrRepository.deleteById(id)
        } else {
            throw RuntimeException("User not found")
        }
    }
}