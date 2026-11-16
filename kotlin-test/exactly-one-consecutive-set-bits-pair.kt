package exactlyoneconsecutivesetbitspair

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ExactlyOneConsecutiveSetBitsPairTest {
    private val solution = Solution()

    @Test
    fun testSinglePair() {
        assertTrue(solution.consecutiveSetBits(3))
        assertTrue(solution.consecutiveSetBits(6))
        assertTrue(solution.consecutiveSetBits(12))
    }

    @Test
    fun testNoPair() {
        assertFalse(solution.consecutiveSetBits(5))
        assertFalse(solution.consecutiveSetBits(10))
        assertFalse(solution.consecutiveSetBits(1))
    }

    @Test
    fun testMultiplePairs() {
        assertFalse(solution.consecutiveSetBits(7))
        assertFalse(solution.consecutiveSetBits(15))
    }

    @Test
    fun testZero() {
        assertFalse(solution.consecutiveSetBits(0))
    }

    @Test
    fun testLargerValues() {
        assertTrue(solution.consecutiveSetBits(24))
        assertFalse(solution.consecutiveSetBits(21))
    }
}
