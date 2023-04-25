package com.sawapps.userpreferences

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

abstract class UserPreferencesTests {
    lateinit var settings: UserPreferences

    abstract fun createSettings(): UserPreferences

    @BeforeTest
    fun setup() {
        settings = createSettings()
    }

    @AfterTest
    fun tearDown() {
        settings.clear()
    }

    @Test
    fun clearAllElements() {
        // given
        settings.addString("1", "value")
        settings.addBoolean("2", true)
        settings.addFloat("3", Float.MIN_VALUE)
        settings.addInt("4", Int.MIN_VALUE)
        settings.addDouble("5", Double.MIN_VALUE)
        settings.addLong("6", Long.MIN_VALUE)

        // when
        settings.clear()

        // then
        assertNull(settings.getString("1"))
        assertNull(settings.getBoolean("2"))
        assertNull(settings.getFloat("3"))
        assertNull(settings.getInt("4"))
        assertNull(settings.getDouble("5"))
        assertNull(settings.getLong("6"))
    }

    @Test
    fun removeSingleElement() {
        // given
        settings.addString("1", "value")
        settings.addBoolean("2", true)
        settings.addFloat("3", Float.MIN_VALUE)
        settings.addInt("4", Int.MIN_VALUE)
        settings.addDouble("5", Double.MIN_VALUE)
        settings.addLong("6", Long.MIN_VALUE)

        // when
        settings.remove("1")
        settings.remove("2")
        settings.remove("3")
        settings.remove("4")
        settings.remove("5")
        settings.remove("6")

        // then
        assertNull(settings.getString("1"))
        assertNull(settings.getBoolean("2"))
        assertNull(settings.getFloat("3"))
        assertNull(settings.getInt("4"))
        assertNull(settings.getDouble("5"))
        assertNull(settings.getLong("6"))
    }

    @Test
    fun getNotExistingStringValue() {
        // given
        val key = "key"

        // when
        val result = settings.getString(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultStringValue() {
        // given
        val key = "key"
        val value = "value"

        // when
        val result = settings.getString(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addStringValue() {
        // given
        val key = "key"
        val value = "value"

        // when
        settings.addString(key, value)
        val result = settings.getString(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingIntValue() {
        // given
        val key = "key"

        // when
        val result = settings.getInt(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultIntValue() {
        // given
        val key = "key"
        val value = Int.MAX_VALUE

        // when
        val result = settings.getInt(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addIntValue() {
        // given
        val key = "key"
        val value = Int.MAX_VALUE

        // when
        settings.addInt(key, value)
        val result = settings.getInt(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingLongValue() {
        // given
        val key = "key"

        // when
        val result = settings.getLong(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultLongValue() {
        // given
        val key = "key"
        val value = Long.MAX_VALUE

        // when
        val result = settings.getLong(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addLongValue() {
        // given
        val key = "key"
        val value = Long.MAX_VALUE

        // when
        settings.addLong(key, value)
        val result = settings.getLong(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingDoubleValue() {
        // given
        val key = "key"

        // when
        val result = settings.getDouble(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultDoubleValue() {
        // given
        val key = "key"
        val value = Double.MAX_VALUE

        // when
        val result = settings.getDouble(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addDoubleValue() {
        // given
        val key = "key"
        val value = Double.MAX_VALUE

        // when
        settings.addDouble(key, value)
        val result = settings.getDouble(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingFloatValue() {
        // given
        val key = "key"

        // when
        val result = settings.getFloat(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultFloatValue() {
        // given
        val key = "key"
        val value = Float.MAX_VALUE

        // when
        val result = settings.getFloat(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addFloatValue() {
        // given
        val key = "key"
        val value = Float.MAX_VALUE

        // when
        settings.addFloat(key, value)
        val result = settings.getFloat(key)

        // then
        assertEquals(value, result)
    }

    @Test
    fun getNotExistingBooleanValue() {
        // given
        val key = "key"

        // when
        val result = settings.getBoolean(key)

        // then
        assertNull(result)
    }

    @Test
    fun getNotExistingDefaultBooleanValue() {
        // given
        val key = "key"
        val value = true

        // when
        val result = settings.getBoolean(key, defaultValue = value)

        // then
        assertEquals(value, result)
    }

    @Test
    fun addBooleanValue() {
        // given
        val key = "key"
        val value = true

        // when
        settings.addBoolean(key, value)
        val result = settings.getBoolean(key)

        // then
        assertEquals(value, result)
    }
}