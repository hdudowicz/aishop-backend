package com.hddev.aishopcore.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
open class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var email: String? = null
    var password: String? = null
    var token: String? = null

    @OneToMany
    var predictions: ArrayList<PredictionEntity> = arrayListOf()
}