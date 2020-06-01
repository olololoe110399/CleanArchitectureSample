package com.sun_asterisk.clean_architecture_sample2

import android.app.Application
import com.sun_asterisk.clean_architecture_sample2.di.module.MovieModule
import com.sun_asterisk.clean_architecture_sample2.di.module.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(MovieModule, NetworkModule))
        }
    }
}
