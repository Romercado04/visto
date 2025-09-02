package com.example.visto.auth.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.visto.auth.data.dto.toUserModel
import com.example.visto.auth.domain.usecase.CreateUserWithEmailAndPasswordUseCase
import com.example.visto.auth.domain.usecase.GetCurrentUserUseCase
import com.example.visto.auth.domain.usecase.SignInWithEmailUseCase
import com.example.visto.auth.domain.usecase.SignInWithGoogleUseCase
import com.example.visto.auth.domain.usecase.SignOutUseCase
import com.example.visto.network.NetworkResponse
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val signInWithEmail: SignInWithEmailUseCase,
    private val signInWithGoogle: SignInWithGoogleUseCase,
    private val signOut: SignOutUseCase,
    private val getCurrentUser: GetCurrentUserUseCase,
    private val createUserWithEmail: CreateUserWithEmailAndPasswordUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun signInEmail(email: String, password: String) {
        viewModelScope.launch {
            signInWithEmail(email, password)
                .collect { response ->
                    _uiState.value = when (response) {
                        is NetworkResponse.Loading -> LoginUiState(isLoading = true)
                        is NetworkResponse.Success -> LoginUiState(user = response.data?.toUserModel())
                        is NetworkResponse.Failure -> LoginUiState(error = response.error)
                    }
                }
        }
    }

    fun signInGoogle(credential: AuthCredential) {
        viewModelScope.launch {
            signInWithGoogle(credential)
                .collect { response ->
                    _uiState.value = when (response) {
                        is NetworkResponse.Loading -> LoginUiState(isLoading = true)
                        is NetworkResponse.Success -> LoginUiState(user = response.data?.toUserModel())
                        is NetworkResponse.Failure -> LoginUiState(error = response.error)
                    }
                }
        }
    }

    fun createUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            createUserWithEmail(name, email, password)
                .collect { response ->
                    _uiState.value = when (response) {
                        is NetworkResponse.Loading -> LoginUiState(isLoading = true)
                        is NetworkResponse.Success -> LoginUiState(user = response.data?.toUserModel())
                        is NetworkResponse.Failure -> LoginUiState(error = response.error)
                    }
                }
        }
    }

    fun signOutUser() {
        viewModelScope.launch {
            try {
                signOut()
                _uiState.value = LoginUiState() // resetea todo
            } catch (e: Exception) {
                _uiState.value = LoginUiState(error = e.message)
            }
        }
    }

    fun getCurrentUserInfo() {
        viewModelScope.launch {
            try {
                val user = getCurrentUser()?.toUserModel()
                _uiState.value = LoginUiState(user = user)
            } catch (e: Exception) {
                _uiState.value = LoginUiState(error = e.message)
            }
        }
    }
}


