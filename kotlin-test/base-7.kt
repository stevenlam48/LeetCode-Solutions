package base7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Base7Test {
    private val solution = Solution()

    @Test
    fun zero() {
        assertEquals("0", solution.convertToBase7(0))
    }

    @Test
    fun positiveExample() {
        assertEquals("202", solution.convertToBase7(100))
    }

    @Test
    fun negativeExample() {
        assertEquals("-10", solution.convertToBase7(-7))
    }

    @Test
    fun singleDigit() {
        assertEquals("6", solution.convertToBase7(6))
    }

    @Test
    fun repeatedBaseSevenDigit() {
        assertEquals("66", solution.convertToBase7(48))
    }
}
