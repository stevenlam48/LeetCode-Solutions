package removekdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveKDigitsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("1219", solution.removeKdigits("1432219", 3))
    }

    @Test
    fun testExample2() {
        assertEquals("200", solution.removeKdigits("10200", 1))
    }

    @Test
    fun testRemoveAllDigits() {
        assertEquals("0", solution.removeKdigits("10", 2))
    }

    @Test
    fun testIncreasingDigits() {
        assertEquals("11", solution.removeKdigits("112", 1))
    }

    @Test
    fun testAllZerosAfterRemoval() {
        assertEquals("0", solution.removeKdigits("100", 1))
    }

    @Test
    fun testRemainingZero() {
        assertEquals("0", solution.removeKdigits("1234567890", 9))
    }
}
