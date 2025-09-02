package com.example.visto.auth.di

import com.example.visto.R
import com.example.visto.auth.data.provider.FirebaseAuthProvider
import com.example.visto.auth.domain.provider.AuthProvider
import com.example.visto.auth.domain.usecase.CreateUserWithEmailAndPasswordUseCase
import com.example.visto.auth.domain.usecase.GetCurrentUserUseCase
import com.example.visto.auth.domain.usecase.SignInWithEmailUseCase
import com.example.visto.auth.domain.usecase.SignInWithGoogleUseCase
import com.example.visto.auth.domain.usecase.SignOutUseCase
import com.example.visto.auth.presentation.viewmodel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {

    // Firebase Auth instance
    single<FirebaseAuth> { Firebase.auth }

    // GoogleSignIn Client
    single<GoogleSignInClient> {
        val context = androidContext()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        GoogleSignIn.getClient(context, gso)
    }

    // Providers
    single<AuthProvider> { FirebaseAuthProvider(auth = get()) }

    // Use cases
    factory { SignInWithEmailUseCase(provider = get()) }
    factory { SignInWithGoogleUseCase(provider = get()) }
    factory { SignOutUseCase(authProvider = get()) }
    factory { GetCurrentUserUseCase(authProvider = get()) }
    factory { CreateUserWithEmailAndPasswordUseCase(authProvider = get()) }

    // ViewModel
    viewModel {
        AuthViewModel(
            signInWithEmail = get(),
            signInWithGoogle = get(),
            signOut = get(),
            getCurrentUser = get(),
            createUserWithEmail = get()
        )
    }
}

