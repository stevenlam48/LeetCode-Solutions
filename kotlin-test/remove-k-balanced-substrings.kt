package removekbalancedsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveKBalancedSubstringsTest {
    private val solution = Solution()

    @Test
    fun testBalancedPair() {
        assertEquals("", solution.removeSubstring("(())", 1))
    }

    @Test
    fun testTwoBalancedPairs() {
        assertEquals("", solution.removeSubstring("()()", 1))
    }

    @Test
    fun testNestedWithLargerK() {
        assertEquals("()", solution.removeSubstring("((()))", 2))
    }

    @Test
    fun testUnbalancedRemainder() {
        assertEquals("(", solution.removeSubstring("(()", 1))
    }

    @Test
    fun testEmptyString() {
        assertEquals("", solution.removeSubstring("", 1))
    }

    @Test
    fun testKTooLarge() {
        assertEquals("(((", solution.removeSubstring("(((", 3))
    }
}
