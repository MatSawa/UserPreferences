package com.sawapps.kmmsample

import com.sawapps.userpreferences.UserPreferences

interface UserRepository {
    var userName: String
}

class UserRepositoryImpl(private val userPreferences: UserPreferences) : UserRepository {
    override var userName: String
        get() = userPreferences.getString(USER_NAME_KEY, "")
        set(value) = userPreferences.addString(USER_NAME_KEY, value)

    companion object {
        private const val USER_NAME_KEY = "user_name"
    }
}
