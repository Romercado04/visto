package com.example.visto.auth.presentation.viewmodel

import com.example.visto.auth.domain.models.UserModel

data class LoginUiState(
    val isLoading: Boolean = false,
    val user: UserModel? = null,
    val error: String? = null
)


