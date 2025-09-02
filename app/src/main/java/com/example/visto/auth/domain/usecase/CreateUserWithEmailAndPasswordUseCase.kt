package com.example.visto.auth.domain.usecase

import com.example.visto.auth.domain.provider.AuthProvider

class CreateUserWithEmailAndPasswordUseCase(private val authProvider: AuthProvider) {
    suspend operator fun invoke(name: String, email: String, password: String) =
        authProvider.createUserWithEmailAndPassword(name, email, password)
}