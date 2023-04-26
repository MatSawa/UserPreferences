package com.matsawa.kmmsample

import org.koin.core.module.Module
import org.koin.dsl.module

expect fun platformModule(): List<Module>

fun appModule() = listOf(repositoryModule) + platformModule()

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
}