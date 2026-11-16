package checkifwordequalssummationoftwowords

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfWordEqualsSummationOfTwoWordsTest {
    private val solution = Solution()

    @Test
    fun testSumMatches() {
        assertTrue(solution.isSumEqual("acb", "cba", "cdb"))
    }

    @Test
    fun testZeros() {
        assertTrue(solution.isSumEqual("aaa", "a", "a"))
    }

    @Test
    fun testSumMismatch() {
        assertFalse(solution.isSumEqual("aaa", "a", "b"))
    }

    @Test
    fun testCarry() {
        assertTrue(solution.isSumEqual("ab", "bc", "bd"))
    }
}
