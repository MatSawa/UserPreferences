package com.sawapps.userpreferences

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

abstract class UserPreferencesTests {
    lateinit var userPreferences: UserPreferences

    abstract fun createUserPreferences(): UserPreferences

    @BeforeTest
    fun setup() {
        userPreferences = createUserPreferences()
    }

    @AfterTest
    fun tearDown() {
        userPreferences.clear()
    }

    @Test
    fun clearAllElements() {
        // given
        userPreferences.addString("1", "value")
        userPreferences.addBoolean("2", true)
        userPreferences.addFloat("3", Float.MIN_VALUE)
        userPreferences.addInt("4", Int.MIN_VALUE)
        userPreferences.addDouble("5", Double.MIN_VALUE)
        userPreferences.addLong("6", Long.MIN_VALUE)

        // when
        userPreferences.clear()

        // then
        assertNull(userPreferences.getString("1"))
        assertNull(userPreferences.getBoolean("2"))
        assertNull(userPreferences.getFloat("3"))
        assertNull(userPreferences.getInt("4"))
        assertNull(userPreferences.getDouble("5"))
        assertNull(userPreferences.getLong("6"))
    }

    @Test
    fun removeSingleElement() {
        // given
        userPreferences.addString("1", "value")
        userPreferences.addBoolean("2", true)
        userPreferences.addFloat("3", Float.MIN_VALUE)
        userPreferences.addInt("4", Int.MIN_VALUE)
        userPreferences.addDouble("5", Double.MIN_VALUE)
        userPreferences.addLong("6", Long.MIN_VALUE)

        // when
        userPreferences.remove("1")
        userPreferences.remove("2")
        userPreferences.remove("3")
        userPreferences.remove("4")
        userPreferences.remove("5")
        userPreferences.remove("6")

        // then
        assertNull(userPreferences.getString("1"))
        assertNull(userPreferences.getBoolean("2"))
        assertNull(userPreferences.getFloat("3"))
        assertNull(userPreferences.getInt("4"))
        assertNull(userPreferences.getDouble("5"))
        assertNull(userPreferences.getLong("6"))
    }

    @Test
    fun getNotExistingStringValue() {
        // given
        val key = "key"

        // when
        val result = userPreferences.getString(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultStringValue() {
        // given
        val key = "key"
        val value = "value"

        // when
        val result = userPreferences.getString(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addStringValue() {
        // given
        val key = "key"
        val value = "value"

        // when
        userPreferences.addString(key, value)
        val result = userPreferences.getString(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingIntValue() {
        // given
        val key = "key"

        // when
        val result = userPreferences.getInt(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultIntValue() {
        // given
        val key = "key"
        val value = Int.MAX_VALUE

        // when
        val result = userPreferences.getInt(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addIntValue() {
        // given
        val key = "key"
        val value = Int.MAX_VALUE

        // when
        userPreferences.addInt(key, value)
        val result = userPreferences.getInt(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingLongValue() {
        // given
        val key = "key"

        // when
        val result = userPreferences.getLong(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultLongValue() {
        // given
        val key = "key"
        val value = Long.MAX_VALUE

        // when
        val result = userPreferences.getLong(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addLongValue() {
        // given
        val key = "key"
        val value = Long.MAX_VALUE

        // when
        userPreferences.addLong(key, value)
        val result = userPreferences.getLong(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingDoubleValue() {
        // given
        val key = "key"

        // when
        val result = userPreferences.getDouble(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultDoubleValue() {
        // given
        val key = "key"
        val value = Double.MAX_VALUE

        // when
        val result = userPreferences.getDouble(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addDoubleValue() {
        // given
        val key = "key"
        val value = Double.MAX_VALUE

        // when
        userPreferences.addDouble(key, value)
        val result = userPreferences.getDouble(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingFloatValue() {
        // given
        val key = "key"

        // when
        val result = userPreferences.getFloat(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultFloatValue() {
        // given
        val key = "key"
        val value = Float.MAX_VALUE

        // when
        val result = userPreferences.getFloat(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addFloatValue() {
        // given
        val key = "key"
        val value = Float.MAX_VALUE

        // when
        userPreferences.addFloat(key, value)
        val result = userPreferences.getFloat(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingBooleanValue() {
        // given
        val key = "key"

        // when
        val result = userPreferences.getBoolean(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultBooleanValue() {
        // given
        val key = "key"
        val value = true

        // when
        val result = userPreferences.getBoolean(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addBooleanValue() {
        // given
        val key = "key"
        val value = true

        // when
        userPreferences.addBoolean(key, value)
        val result = userPreferences.getBoolean(key)

        // then
        assertEquals(value, result)
    }
}