package com.example.invoice.service

import com.example.invoice.entity.Country
import com.example.invoice.repository.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService {
    @Autowired
    lateinit var countryRepository: CountryRepository

    fun list(): List<Country> {
        return countryRepository.findAll()
    }

    fun getById(id: Long): Country {
        return countryRepository.findById(id).orElseThrow { RuntimeException("Country not found") }
    }

    fun save(country: Country): Country {
        return countryRepository.save(country)
    }

    fun update(id: Long, country: Country): Country {
        val existingCountry = countryRepository.findById(id).orElseThrow { RuntimeException("Country not found") }
        existingCountry.code = country.code
        existingCountry.countryName = country.countryName
        existingCountry.continentName = country.continentName

        return countryRepository.save(existingCountry)
    }

    fun delete(id: Long) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id)
        } else {
            throw RuntimeException("Country not found")
        }
    }
}




