package com.example.invoice.repository

import com.example.invoice.entity.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository <Country, Long?> {
}