package com.matsawa.kmmsample

import com.matsawa.userpreferences.UserPreferences
import com.matsawa.userpreferences.UserPreferencesImpl
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): List<Module> = listOf(settingsModule)

val settingsModule = module {
    factory<UserPreferences> { UserPreferencesImpl.Factory.create(null) }
}