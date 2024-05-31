package com.example.invoice.repository

import com.example.invoice.entity.Merchant
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository : JpaRepository <Merchant, Long?> {
}