package numbersatmostngivendigitset

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersAtMostNGivenDigitSetTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(20, solution.atMostNGivenDigitSet(listOf("1", "3", "5", "7"), 100))
    }

    @Test
    fun testExample2() {
        assertEquals(29523, solution.atMostNGivenDigitSet(listOf("1", "4", "9"), 1000000000))
    }

    @Test
    fun testSingleDigit() {
        assertEquals(1, solution.atMostNGivenDigitSet(listOf("7"), 8))
    }

    @Test
    fun testSingleDigitTooLarge() {
        assertEquals(0, solution.atMostNGivenDigitSet(listOf("7"), 6))
    }

    @Test
    fun testAllDigits() {
        assertEquals(9, solution.atMostNGivenDigitSet(listOf("1", "2", "3", "4", "5", "6", "7", "8", "9"), 9))
    }
}
