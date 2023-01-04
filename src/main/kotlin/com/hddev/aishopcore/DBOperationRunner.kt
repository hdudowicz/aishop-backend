package com.hddev.aishopcore

import com.hddev.aishopcore.repository.PredictionRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DBOperationRunner constructor(val predictionRepo: PredictionRepository): CommandLineRunner {

    override fun run(vararg args: String?) {
//        predictionRepo.saveAll(
//            listOf(
//                PredictionEntity(
//                    id = Random.nextLong(),
//                    status = GenerationStatus.starting,
//
//                )
//            )
//        )
    }
}