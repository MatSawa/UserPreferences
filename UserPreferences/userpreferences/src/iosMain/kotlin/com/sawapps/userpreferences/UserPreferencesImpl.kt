package com.sawapps.userpreferences

import platform.Foundation.NSBundle
import platform.Foundation.NSUserDefaults

public class UserPreferencesImpl(private val userDefaults: NSUserDefaults) : UserPreferences {
    public object Factory : UserPreferences.Factory {
        private val bundleIdentifier = NSBundle.mainBundle.bundleIdentifier

        public override fun create(name: String?): UserPreferencesImpl {
            if (name == bundleIdentifier) throw IllegalStateException("Name cannot be the same as bundle identifier")

            val userDefaultsName = name ?: "$bundleIdentifier.userpreferences"
            return UserPreferencesImpl(NSUserDefaults(suiteName = userDefaultsName))
        }
    }

    private fun add(key: String, value: Any) = userDefaults.setObject(value, key)

    override fun contains(key: String) = userDefaults.objectForKey(key) != null

    override fun clear() = userDefaults.dictionaryRepresentation()
        .keys
        .mapNotNull { it as? String }
        .forEach { key ->
            userDefaults.removeObjectForKey(key)
        }

    // region String
    override fun addString(key: String, value: String) = add(value, key)
    override fun getString(key: String): String? = userDefaults.stringForKey(key)
    override fun getString(key: String, defaultValue: String): String = getString(key) ?: defaultValue
    // endregion String

    // region Int
    override fun addInt(key: String, value: Int) = add(key, value)
    override fun getInt(key: String): Int? = getIfContains(key) { userDefaults.integerForKey(key).toInt() }
    override fun getInt(key: String, defaultValue: Int): Int = getInt(key) ?: defaultValue
    // endregion Int

    // region Long
    override fun addLong(key: String, value: Long) = add(key, value)
    override fun getLong(key: String): Long? = getIfContains(key) { userDefaults.objectForKey(key) as? Long }
    override fun getLong(key: String, defaultValue: Long): Long = getLong(key) ?: defaultValue
    // endregion Long

    // region Double
    override fun addDouble(key: String, value: Double) = add(key, value)
    override fun getDouble(key: String): Double? = if (contains(key)) userDefaults.doubleForKey(key) else null
    override fun getDouble(key: String, defaultValue: Double): Double = getDouble(key) ?: defaultValue
    // endregion Double

    // region Float
    override fun addFloat(key: String, value: Float) = add(key, value)
    override fun getFloat(key: String): Float? = if (contains(key)) userDefaults.floatForKey(key) else null
    override fun getFloat(key: String, defaultValue: Float): Float = getFloat(key) ?: defaultValue
    // endregion Float

    // region boolean
    override fun addBoolean(key: String, value: Boolean) = add(key, value)
    override fun getBoolean(key: String): Boolean? = if (contains(key)) userDefaults.boolForKey(key) else null
    override fun getBoolean(key: String, defaultValue: Boolean): Boolean = getBoolean(key) ?: defaultValue
    // endregion boolean
}