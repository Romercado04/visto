package com.example.visto.auth.presentation.viewmodel

sealed class AuthEvent {
    data class SignInEmail(val email: String, val password: String) : AuthEvent()
    data class SignUpEmail(val email: String, val password: String) : AuthEvent()
    data class SignInGoogle(val idToken: String) : AuthEvent()
}
