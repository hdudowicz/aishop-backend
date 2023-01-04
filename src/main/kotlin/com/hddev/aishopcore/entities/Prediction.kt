package com.hddev.aishopcore.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.hddev.aishopcore.model.GenerationStatus
import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.time.LocalDateTime


@Entity
@Table(name = "predictions")
open class Prediction() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    //    var version: String? = null,
    var createdAt: LocalDateTime? = LocalDateTime.now()
    var startedAt: LocalDateTime? = null
    var completedAt: LocalDateTime? = null
    var status: GenerationStatus? = null
    var prompt: String? = null
    @Lob()
    @Column(name = "image", columnDefinition = "LONGBLOB")
    var image: ByteArray? = null
    var predictTime: Double? = null
    var replicateSlug: String? = null


    var userId: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable=false, updatable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private var user: User? = null
    constructor(
            id: Long? = null,
            createdAt: LocalDateTime? = LocalDateTime.now(),
            startedAt: LocalDateTime? = null,
            completedAt: LocalDateTime? = null,
            status: GenerationStatus?,
            prompt: String? = null,
            image: ByteArray? = null,
            predictTime: Double? = null,
            replicateSlug: String? = null
    ): this(){
        // Set the passed values to the corresponding fields in the object
        this.id = id
        this.createdAt = createdAt
        this.startedAt = startedAt
        this.completedAt = completedAt
        this.status = status
        this.prompt = prompt
        this.image = image
        this.predictTime = predictTime
        this.replicateSlug = replicateSlug
    }
}