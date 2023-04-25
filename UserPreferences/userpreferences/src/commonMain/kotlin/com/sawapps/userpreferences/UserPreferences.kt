package com.sawapps.userpreferences

internal fun <T> UserPreferences.getIfContains(key: String, get: () -> T): T? = if (contains(key)) get() else null

interface UserPreferences {
    interface Factory {
        fun create(name: String?): UserPreferences
    }

    fun clear()
    fun contains(key: String): Boolean
    fun remove(key: String)

    // region String
    fun addString(key: String, value: String)
    fun getString(key: String): String?
    fun getString(key: String, defaultValue: String): String
    // endregion String

    // region Int
    fun addInt(key: String, value: Int)
    fun getInt(key: String): Int?
    fun getInt(key: String, defaultValue: Int): Int
    // endregion Int

    // region Int
    fun addLong(key: String, value: Long)
    fun getLong(key: String): Long?
    fun getLong(key: String, defaultValue: Long): Long
    // endregion Int

    // region Double
    fun addDouble(key: String, value: Double)
    fun getDouble(key: String): Double?
    fun getDouble(key: String, defaultValue: Double): Double
    // endregion Double

    // region Float
    fun addFloat(key: String, value: Float)
    fun getFloat(key: String): Float?
    fun getFloat(key: String, defaultValue: Float): Float
    // endregion Float

    // region Boolean
    fun addBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean?
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    // endregion Boolean
}
