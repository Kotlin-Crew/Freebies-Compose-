package com.kotlincrew.freebies.auth.data.repository

import android.content.SharedPreferences
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.kotlincrew.freebies.auth.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : AuthRepository {

    companion object{
        private const val REMEBER_ME = "remeber_me"
    }

    override suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signup(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getRememberAccount(): Boolean {
        return sharedPreferences.getBoolean(REMEBER_ME,false)
    }

    override fun setRememberAccount(isChecked: Boolean) {
        sharedPreferences.edit().putBoolean(REMEBER_ME, isChecked).apply()
    }

    override fun getUserId(): String? {
        return Firebase.auth.currentUser?.uid
    }

}