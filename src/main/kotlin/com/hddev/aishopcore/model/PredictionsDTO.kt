package com.hddev.aishopcore.model

import com.hddev.aishopcore.entities.PredictionEntity

data class PredictionsDTO(
        val predictions: List<PredictionEntity>
)