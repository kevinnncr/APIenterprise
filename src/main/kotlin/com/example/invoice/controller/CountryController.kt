package com.example.invoice.controller
import com.example.invoice.entity.Country
import com.example.invoice.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
@RestController
@RequestMapping("/countries")
class CountryController {
    @Autowired
    lateinit var countryService: CountryService

    @GetMapping
    fun list(): List<Country> {
        return countryService.list()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Country {
        return countryService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody country: Country): Country {
        return countryService.save(country)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody country: Country): Country {
        return countryService.update(id, country)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String {
        countryService.delete(id)
        return "Country with id $id deleted successfully"
    }
}