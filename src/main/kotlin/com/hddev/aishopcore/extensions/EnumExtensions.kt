package com.hddev.aishopcore.extensions

/**
 * Returns an enum entry with specified name.
 */
inline fun <reified T : Enum<*>> enumValueOrNull(name: String?): T? =
        T::class.java.enumConstants.firstOrNull { it.name == name }