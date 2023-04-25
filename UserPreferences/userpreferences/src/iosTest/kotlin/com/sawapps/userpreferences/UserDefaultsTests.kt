package com.sawapps.userpreferences

class UserDefaultsTests : UserPreferencesTests() {
    override fun createUserPreferences(): UserPreferences = UserPreferencesImpl.Factory.create(null)
}