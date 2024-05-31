package com.example.invoice.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "userr")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var fullname: String? = null

    @Column(nullable = false, unique = true)
    var email: String? = null

    var gender: String? = null

    @Column(name = "date_of_birth")
    var dateOfBirth: Date? = null

    @Column(name = "created_at")
    var createdAt: Date? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    var country: Country? = null
}