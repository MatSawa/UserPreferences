package com.sawapps.kmmsample.android

import android.app.Application
import com.sawapps.kmmsample.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule() + listOf(viewModelModule()))
        }
    }
}

private fun viewModelModule() = module {
    viewModel { FormViewModel(get()) }
}