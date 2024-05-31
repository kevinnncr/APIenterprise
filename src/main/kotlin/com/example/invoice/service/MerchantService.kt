package com.example.invoice.service
import com.example.invoice.entity.Merchant
import com.example.invoice.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
@Service
class MerchantService {
    @Autowired
    lateinit var merchantRepository: MerchantRepository

    fun list(): List<Merchant> {
        return merchantRepository.findAll()
    }

    fun getById(id: Long): Merchant {
        return merchantRepository.findById(id).orElseThrow { RuntimeException("Merchant not found") }
    }

    fun save(merchant: Merchant): Merchant {
        return merchantRepository.save(merchant)
    }

    fun update(id: Long, merchant: Merchant): Merchant {
        val existingMerchant = merchantRepository.findById(id).orElseThrow { RuntimeException("Merchant not found") }
        existingMerchant.merchantName = merchant.merchantName
        existingMerchant.createdAt = merchant.createdAt
        existingMerchant.user = merchant.user
        existingMerchant.country = merchant.country

        return merchantRepository.save(existingMerchant)
    }

    fun delete(id: Long) {
        if (merchantRepository.existsById(id)) {
            merchantRepository.deleteById(id)
        } else {
            throw RuntimeException("Merchant not found")
        }
    }
}