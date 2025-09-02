package com.example.visto.auth.domain.provider

import com.example.visto.network.NetworkResponse
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface AuthProvider {
    suspend fun signInWithGoogle(credential: AuthCredential): Flow<NetworkResponse<FirebaseUser>>

    suspend fun signOut()

    suspend fun getCurrentUser(): FirebaseUser?

    suspend fun signInWithEmailAndPassword(email: String, password: String): Flow<NetworkResponse<FirebaseUser>>

    suspend fun createUserWithEmailAndPassword(
        name: String,
        email: String,
        password: String
    ): Flow<NetworkResponse<FirebaseUser>>
}
