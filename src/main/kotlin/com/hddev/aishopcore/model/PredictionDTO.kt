package com.hddev.aishopcore.model

import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList


data class PredictionDTO(
    var id: String? = null,
    var version: String? = null,
    var urls: Urls? = null,
    var created_at: LocalDateTime? = null,
    var started_at: LocalDateTime? = null,
    var completed_at: LocalDateTime? = null,
    var source: String? = null,
    var status: String? = null,
    var input: Input? = null,
    var output: ArrayList<String>? = null,
    var error: Any? = null,
    var logs: String? = null,
    var metrics: Metrics? = null
)

data class Input (
    var prompt: String? = null
)

data class Metrics(
    var predict_time: Double = 0.0
)

data class Urls (
    var get: String? = null,
    var cancel: String? = null
)
