package com.example.visto

import android.app.Application
import com.example.visto.auth.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class VistoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VistoApp)
            modules(
                authModule,
            )
        }
    }
}
