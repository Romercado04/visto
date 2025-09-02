package com.example.visto.auth.domain.usecase

import com.example.visto.auth.domain.provider.AuthProvider
import com.example.visto.network.NetworkResponse
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

class SignInWithEmailUseCase(
    private val provider: AuthProvider
) {
    suspend operator fun invoke(email: String, password: String): Flow<NetworkResponse<FirebaseUser>> {
        return provider.signInWithEmailAndPassword(email, password)
    }
}
