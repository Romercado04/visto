package com.example.visto.auth.domain.usecase

import com.example.visto.auth.domain.provider.AuthProvider

class SignOutUseCase(private val authProvider: AuthProvider) {
    suspend operator fun invoke() = authProvider.signOut()
}