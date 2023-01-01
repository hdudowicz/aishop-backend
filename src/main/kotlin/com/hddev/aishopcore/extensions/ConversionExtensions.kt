package com.hddev.aishopcore.extensions

import com.hddev.aishopcore.entities.PredictionEntity
import com.hddev.aishopcore.model.GenerationStatus
import com.hddev.aishopcore.model.PredictionDTO
import com.hddev.aishopcore.utils.ImageUtils

fun PredictionDTO.toEntity(): PredictionEntity {
    val outputImage = if (this.output?.getOrNull(0) != null) {
        ImageUtils.downloadImageFromUrl(this.output!![0])
    } else {
        null
    }
    return PredictionEntity(
        createdAt = this.created_at,
        startedAt = this.started_at,
        completedAt = this.completed_at,
        status = enumValueOrNull(this.status),
        prompt = this.input?.prompt,
        image = outputImage,
        predictTime = this.metrics?.predict_time,
        replicateSlug = this.id
    )
}

