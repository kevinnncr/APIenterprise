package com.example.invoice.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "merchant")
class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "merchant_name", nullable = false)
    var merchantName: String? = null

    @Column(name = "created_at")
    var createdAt: Date? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userr_id")
    var user: User? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    var country: Country? = null
}