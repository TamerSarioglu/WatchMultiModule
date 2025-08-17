package com.movieapp.core.common.extensions

/**
 * Extension function to check if a string is not null and not blank
 */
fun String?.isNotNullOrBlank(): Boolean {
    return !this.isNullOrBlank()
}

/**
 * Extension function to get a safe substring
 */
fun String.safeSubstring(startIndex: Int, endIndex: Int? = null): String {
    return try {
        if (endIndex != null) {
            this.substring(startIndex.coerceAtLeast(0), endIndex.coerceAtMost(this.length))
        } else {
            this.substring(startIndex.coerceAtLeast(0))
        }
    } catch (e: Exception) {
        this
    }
}

/**
 * Extension function to extract year from date string
 */
fun String.extractYear(): String? {
    return if (this.length >= 4) {
        this.take(4)
    } else {
        null
    }
}