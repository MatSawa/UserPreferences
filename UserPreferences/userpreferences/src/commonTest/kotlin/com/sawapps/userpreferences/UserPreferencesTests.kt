package com.sawapps.userpreferences

import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

abstract class UserPreferencesTests {
    private lateinit var settings: UserPreferences

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

}