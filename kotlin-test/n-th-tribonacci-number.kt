package nthtribonaccinumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NThTribonacciNumberTest {
    @Test
    fun baseCases() {
        assertEquals(0, Solution().tribonacci(0))
        assertEquals(1, Solution().tribonacci(1))
        assertEquals(1, Solution().tribonacci(2))
    }

    @Test
    fun smallValues() {
        assertEquals(2, Solution().tribonacci(3))
        assertEquals(4, Solution().tribonacci(4))
        assertEquals(7, Solution().tribonacci(5))
    }

    @Test
    fun example() {
        assertEquals(1389537, Solution().tribonacci(25))
    }

    @Test
    fun largestInput() {
        assertEquals(2082876103, Solution().tribonacci(37))
    }

    @Test
    fun mediumValue() {
        assertEquals(149, Solution().tribonacci(10))
    }
}
