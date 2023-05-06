package com.example.mf1

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class empValidateInstrumentedTest {

    @Test
    fun testIsInputValid() {
        // Arrange
        val validator = empValidate("1", "type", "John Doe", "johndoe@example.com", "123456789", "Reason")

        // Act
        val result = validator.isInputValid()

        // Assert
        assertTrue(result)
    }

    @Test
    fun testIsIdUnique() {
        // Arrange
        val validator1 = empValidate("1", "type", "John Doe", "johndoe@example.com", "123456789", "Reason")
        val validator2 = empValidate("2", "type", "Jane Smith", "janesmith@example.com", "987654321", "Reason")
        val validateList = listOf(validator1, validator2)

        // Act
        val result1 = validator1.isIdUnique(validateList)
        val result2 = validator2.isIdUnique(validateList)

        // Assert
        assertTrue(result1)
        assertTrue(result2)
    }

    @Test
    fun testIsValid() {
        // Arrange
        val validator1 = empValidate("1", "type", "John Doe", "johndoe@example.com", "123456789", "Reason")
        val validator2 = empValidate("2", "type", "Jane Smith", "janesmith@example.com", "987654321", "Reason")
        val validateList = listOf(validator1, validator2)

        // Act
        val result1 = validator1.isValid(validateList)
        val result2 = validator2.isValid(validateList)

        // Assert
        assertTrue(result1)
        assertTrue(result2)
    }
}
