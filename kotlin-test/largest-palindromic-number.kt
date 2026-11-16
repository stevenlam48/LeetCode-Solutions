package largestpalindromicnumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestPalindromicNumberTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("7449447", solution.largestPalindromic("444947137"))
    }

    @Test
    fun testExample2() {
        assertEquals("9", solution.largestPalindromic("00009"))
    }

    @Test
    fun testZerosWithPairs() {
        assertEquals("1005001", solution.largestPalindromic("00001105"))
    }

    @Test
    fun testSingleZero() {
        assertEquals("0", solution.largestPalindromic("0"))
    }

    @Test
    fun testSingleDigit() {
        assertEquals("1", solution.largestPalindromic("1"))
    }
}
