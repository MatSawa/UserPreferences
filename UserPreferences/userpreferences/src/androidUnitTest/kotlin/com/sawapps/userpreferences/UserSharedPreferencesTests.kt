package com.sawapps.userpreferences

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [30], manifest = Config.NONE)
class UserSharedPreferencesTests : UserPreferencesTests() {
    override fun createUserPreferences(): UserPreferences = UserPreferencesImpl.Factory(ApplicationProvider.getApplicationContext()).create(null)
}