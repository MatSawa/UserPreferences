package com.sawapps.kmmsample

import com.sawapps.userpreferences.UserPreferences
import com.sawapps.userpreferences.UserPreferencesImpl
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): List<Module> = listOf(settingsModule)

val settingsModule = module {
    factory<UserPreferences> { UserPreferencesImpl.Factory.create(null) }
}