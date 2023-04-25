package com.sawapps.userpreferences

class UserDefaultsWithNameTests : UserPreferencesTests() {
    override fun createSettings(): UserPreferences = UserPreferencesImpl.Factory.create("test")
}