package com.kotlincrew.freebies.auth.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Unit>
    fun getUserId(): String?
}