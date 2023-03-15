package com.test.fitpeotest.util

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val value: T) : Result<T>()
    data class Failure(val error: Throwable? = null) : Result<Nothing>()
}
