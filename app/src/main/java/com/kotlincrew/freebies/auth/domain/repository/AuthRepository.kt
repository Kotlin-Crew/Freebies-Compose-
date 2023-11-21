package com.kotlincrew.freebies.auth.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Unit>
    suspend fun signup(email: String, password: String): Result<Unit>

    fun getRememberAccount(): Boolean
    fun setRememberAccount(isChecked: Boolean)
    fun getUserId(): String?
}