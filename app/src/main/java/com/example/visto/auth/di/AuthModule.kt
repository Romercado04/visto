package com.example.visto.auth.di

import com.example.visto.R
import com.example.visto.auth.data.repository.AuthRepoImpl
import com.example.visto.auth.domain.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val authModule = module {
    single { Firebase.auth }
    single {
        val context = androidContext()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.default_web_client_id)) // este viene de google-services.json
            .requestEmail()
            .build()
        GoogleSignIn.getClient(context, gso)
    }
    single<AuthRepository> { AuthRepoImpl(get(), get()) }
}
