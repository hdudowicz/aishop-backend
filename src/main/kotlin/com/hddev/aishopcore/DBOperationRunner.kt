package com.hddev.aishopcore

import com.hddev.aishopcore.entities.PredictionEntity
import com.hddev.aishopcore.model.GenerationStatus
import com.hddev.aishopcore.repository.PredictionRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class DBOperationRunner constructor(val predictionRepo: PredictionRepository): CommandLineRunner {

    override fun run(vararg args: String?) {
        predictionRepo.saveAll(
            listOf(
                PredictionEntity(
                    id = Random.nextLong(),
                    status = GenerationStatus.starting,

                )
            )
        )
    }
}