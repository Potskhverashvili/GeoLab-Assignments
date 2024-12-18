package com.example.cocktailapp

import android.app.Application
import com.example.cocktailapp.di.networkModule
import com.example.cocktailapp.di.repositoryModule
import com.example.cocktailapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                repositoryModule,
                viewModelsModule
            )
        }
    }
}