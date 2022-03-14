package com.example.retrofithandlestatus.di

import android.app.Application
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class EarthGardenerApplication: Application() {
    companion object{
        lateinit var sSharedPreferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
        val X_AUTH_TOKEN = "X-AUTH-TOKEN"
    }

    override fun onCreate() {
        super.onCreate()

        setUpTimber()

        sSharedPreferences = applicationContext.getSharedPreferences("EARTH_GARDENER",
            Application.MODE_PRIVATE
        )
        editor = sSharedPreferences.edit()

        startKoin{
            androidContext(this@EarthGardenerApplication)
            modules(networkModule, dataSourceModule, repositoryModule, viewModelModule, useCaseModule)
        }

    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }
}