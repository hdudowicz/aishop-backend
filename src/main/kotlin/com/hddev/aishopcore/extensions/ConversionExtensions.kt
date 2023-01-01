package com.hddev.aishopcore.extensions

import com.hddev.aishopcore.entities.PredictionEntity
import com.hddev.aishopcore.model.GenerationStatus
import com.hddev.aishopcore.model.PredictionDTO
import com.hddev.aishopcore.utils.ImageUtils

fun PredictionDTO.toEntity(): PredictionEntity {
    return PredictionEntity(
        id = null,
        createdAt = this.created_at,
        startedAt = this.started_at,
        completedAt = this.completed_at,
        status = enumValueOrNull(this.status),
        prompt = this.input?.prompt,
        image = ImageUtils.downloadImageFromUrl(this.output?.get(0) ?: throw Exception("Image url is null")),
        predictTime = this.metrics?.predict_time,
        replicateSlug = this.id
    )
}

