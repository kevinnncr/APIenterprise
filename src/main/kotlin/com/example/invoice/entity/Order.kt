package com.example.invoice.entity

import jakarta.persistence.*

import java.util.Date

@Entity
@Table(name = "orderr")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var status: String? = null

    @Column(name = "created_at")
    var createdAt: Date? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userr_id")
    var user: User? = null
}