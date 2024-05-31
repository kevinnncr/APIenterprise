package com.example.invoice.entity

import jakarta.persistence.*

@Entity
@Table(name = "country")
class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false, unique = true)
    var code: String? = null

    @Column(name = "country_name", nullable = false)
    var countryName: String? = null

    @Column(name = "continent_name", nullable = false)
    var continentName: String? = null
}