package largestpalindromeproduct

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestPalindromeProductTest {
    private val solution = Solution()

    @Test
    fun testN1() {
        assertEquals(9, solution.largestPalindrome(1))
    }

    @Test
    fun testN2() {
        assertEquals(987, solution.largestPalindrome(2))
    }

    @Test
    fun testN3() {
        assertEquals(123, solution.largestPalindrome(3))
    }

    @Test
    fun testN4() {
        assertEquals(597, solution.largestPalindrome(4))
    }

    @Test
    fun testN8() {
        assertEquals(475, solution.largestPalindrome(8))
    }
}
