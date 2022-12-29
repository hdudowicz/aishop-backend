package com.hddev.aishopcore.entities

import com.hddev.aishopcore.model.GenerationStatus
import jakarta.persistence.*
import java.util.*
import kotlin.collections.ArrayList


@Entity
@Table(name = "prediction")
class PredictionEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
//    var version: String? = null
    var createdAt: Date? = null
    var startedAt: Date? = null
    var completedAt: Date? = null
    var status: GenerationStatus? = null
    var prompt: String? = null
    var image: ByteArray? = null

    var predictTime: Double? = null
}