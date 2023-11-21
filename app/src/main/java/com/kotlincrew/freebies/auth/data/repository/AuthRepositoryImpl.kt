package com.kotlincrew.freebies.auth.data.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kotlincrew.freebies.auth.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getUserId(): String? {
        return Firebase.auth.currentUser?.uid
    }

}