package com.hddev.aishopcore.model

data class PredictionRequestDTO(
    var version: String? = null,
    var input: InputDTO? = null
)

data class InputDTO(
    val text: String
)