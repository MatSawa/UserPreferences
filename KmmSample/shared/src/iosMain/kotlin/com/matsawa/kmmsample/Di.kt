package com.matsawa.kmmsample

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

object Di : KoinComponent {
    fun initKoin() {
        startKoin { modules(appModule() + platformModule()) }
    }

    val userRepository: UserRepository
        get() = get()
}