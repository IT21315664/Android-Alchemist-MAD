package com.example.mf1

import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testIsTypeValid() {
        val empValidate = empValidate("1", "Type", "Name", "email@example.com", "123456789", "Reason")
        assertTrue(empValidate.isTypeValid())
    }

    @Test
    fun testIsTypeValid_empty() {
        val empValidate = empValidate("1", "", "Name", "email@example.com", "123456789", "Reason")
        assertFalse(empValidate.isTypeValid())
    }

    @Test
    fun testIsInputValid() {
        val empValidate = empValidate("1", "Type", "Name", "email@example.com", "123456789", "Reason")
        assertTrue(empValidate.isInputValid())
    }

    @Test
    fun testIsInputValid_emptyFields() {
        val empValidate = empValidate("1", "", "", "", "", "")
        assertFalse(empValidate.isInputValid())
    }

    @Test
    fun testIsIdUnique_unique() {
        val empValidateLists = listOf(
            empValidate("1", "Type1", "Name1", "email1@example.com", "123456789", "Reason1"),
            empValidate("2", "Type2", "Name2", "email2@example.com", "987654321", "Reason2")
        )
        val empValidate = empValidate("3", "Type3", "Name3", "email3@example.com", "111111111", "Reason3")
        assertTrue(empValidate.isIdUnique(empValidateLists))
    }

    @Test
    fun testIsIdUnique_notUnique() {
        val empValidateLists = listOf(
            empValidate("1", "Type1", "Name1", "email1@example.com", "123456789", "Reason1"),
            empValidate("2", "Type2", "Name2", "email2@example.com", "987654321", "Reason2"),
            empValidate("3", "Type3", "Name3", "email3@example.com", "111111111", "Reason3")
        )
        val empValidate = empValidate("2", "Type4", "Name4", "email4@example.com", "555555555", "Reason4")
        assertFalse(empValidate.isIdUnique(empValidateLists))
    }
}
