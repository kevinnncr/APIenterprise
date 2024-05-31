package com.example.invoice.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "product")
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    var description: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    var merchant: Merchant? = null

    var price: Double? = null

    var status: String? = null

    @Column(name = "created_at")
    var createdAt: Date? = null
}