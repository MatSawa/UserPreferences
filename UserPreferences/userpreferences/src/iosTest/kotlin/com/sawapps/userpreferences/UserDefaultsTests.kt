package com.sawapps.userpreferences

class UserDefaultsTests : UserPreferencesTests() {
    override fun createSettings(): UserPreferences = UserPreferencesImpl.Factory.create("test")
}