package com.hddev.aishopcore.repository

import com.hddev.aishopcore.entities.PredictionEntity
import com.hddev.aishopcore.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PredictionRepository: JpaRepository<PredictionEntity, Long>{

    fun findPredictionById(id: Long): PredictionEntity?

    fun findByUser(user: User): List<PredictionEntity>
}