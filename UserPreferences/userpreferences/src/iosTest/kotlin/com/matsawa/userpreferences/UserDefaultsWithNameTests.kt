package com.matsawa.userpreferences

class UserDefaultsWithNameTests : UserPreferencesTests() {
    override fun createUserPreferences(): UserPreferences = UserPreferencesImpl.Factory.create("test")
}