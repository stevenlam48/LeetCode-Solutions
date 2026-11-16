package closestfairinteger

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClosestFairIntegerTest {
    @Test
    fun singleDigitAdvancesToTwoDigits() {
        assertEquals(10, Solution().closestFair(1))
    }

    @Test
    fun alreadyFairReturnsInput() {
        assertEquals(10, Solution().closestFair(10))
        assertEquals(25, Solution().closestFair(25))
    }

    @Test
    fun incrementsSuffixWhenPossible() {
        assertEquals(25, Solution().closestFair(24))
    }

    @Test
    fun carriesToNextEvenDigitLength() {
        assertEquals(1001, Solution().closestFair(19))
        assertEquals(1001, Solution().closestFair(99))
    }

    @Test
    fun oddDigitCountUsesNextEvenLength() {
        assertEquals(1001, Solution().closestFair(403))
    }
}
