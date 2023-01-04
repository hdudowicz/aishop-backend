package com.hddev.aishopcore.repository

import com.hddev.aishopcore.entities.Prediction
import com.hddev.aishopcore.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PredictionRepository: JpaRepository<Prediction, Long>{

    fun findPredictionById(id: Long): Prediction?

    fun findPredictionByReplicateSlug(replicateSlug: String): Prediction?

    fun findByUser(user: User): List<Prediction>
}