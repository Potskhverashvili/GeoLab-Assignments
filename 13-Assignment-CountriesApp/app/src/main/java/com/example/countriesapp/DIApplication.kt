package com.example.countriesapp

import android.app.Application
import com.example.countriesapp.di.networkModule
import com.example.countriesapp.di.repositoryModule
import com.example.countriesapp.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DIApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DIApplication)
            modules(networkModule, repositoryModule, viewModelsModule)
        }
    }
}