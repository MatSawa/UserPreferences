package com.sawapps.userpreferences

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

public class UserPreferencesImpl(private val sharedPreferences: SharedPreferences) : UserPreferences {
    public class Factory(context: Context) : UserPreferences.Factory {
        private val appContext: Context = context.applicationContext

        public override fun create(name: String?): UserPreferencesImpl {
            val preferencesName = name ?: "${appContext.packageName}_user_preferences"
            val sharedPreferences = appContext.getSharedPreferences(preferencesName, MODE_PRIVATE)
            return UserPreferencesImpl(sharedPreferences)
        }
    }

    private fun update(edit: (SharedPreferences.Editor) -> Unit) = with(sharedPreferences.edit()) {
        edit(this)
        apply()
    }

    override fun clear() = update { it.clear() }

    override fun contains(key: String) = sharedPreferences.contains(key)

    // region String
    override fun addString(key: String, value: String) = update { it.putString(key, value) }
    override fun getString(key: String): String? = sharedPreferences.getString(key, null)
    override fun getString(key: String, defaultValue: String): String = sharedPreferences.getString(key, defaultValue) ?: defaultValue
    // endregion String

    // region Int
    override fun addInt(key: String, value: Int) = update { it.putInt(key, value) }
    override fun getInt(key: String): Int? = getIfContains(key) { sharedPreferences.getInt(key, 0) }
    override fun getInt(key: String, defaultValue: Int): Int = getInt(key) ?: defaultValue
    // endregion Int

    // region Long
    override fun addLong(key: String, value: Long) = update { it.putLong(key, value) }
    override fun getLong(key: String): Long? = getIfContains(key) { sharedPreferences.getLong(key, 0) }
    override fun getLong(key: String, defaultValue: Long): Long = getLong(key) ?: defaultValue
    // endregion Long

    // region Double
    override fun addDouble(key: String, value: Double) = update { it.putLong(key, value.toRawBits()) }
    override fun getDouble(key: String): Double? = getIfContains(key) { Double.fromBits(sharedPreferences.getLong(key, 0)) }
    override fun getDouble(key: String, defaultValue: Double): Double = getDouble(key) ?: defaultValue
    // endregion Double

    // region Float
    override fun addFloat(key: String, value: Float) = update { it.putFloat(key, value) }
    override fun getFloat(key: String): Float? = getIfContains(key) { sharedPreferences.getFloat(key, 0f) }
    override fun getFloat(key: String, defaultValue: Float): Float = getFloat(key) ?: defaultValue
    // endregion Float

    // region boolean
    override fun addBoolean(key: String, value: Boolean) = update { it.putBoolean(key, value) }
    override fun getBoolean(key: String): Boolean? = getIfContains(key) { sharedPreferences.getBoolean(key, false) }
    override fun getBoolean(key: String, defaultValue: Boolean): Boolean = getBoolean(key) ?: defaultValue
    // endregion boolean
}