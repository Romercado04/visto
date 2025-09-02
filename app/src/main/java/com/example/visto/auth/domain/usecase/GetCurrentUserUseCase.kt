package com.example.visto.auth.domain.usecase

import com.example.visto.auth.domain.provider.AuthProvider
import com.google.firebase.auth.FirebaseUser

class GetCurrentUserUseCase(private val authProvider: AuthProvider) {
    suspend operator fun invoke(): FirebaseUser? = authProvider.getCurrentUser()
}