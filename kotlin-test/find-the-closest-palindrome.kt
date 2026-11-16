package findtheclosestpalindrome

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheClosestPalindromeTest {
    @Test
    fun findsNearbyPalindrome() {
        assertEquals("121", Solution().nearestPalindromic("123"))
    }

    @Test
    fun excludesOriginalPalindrome() {
        assertEquals("9", Solution().nearestPalindromic("11"))
    }

    @Test
    fun changesDigitCountAtPowerOfTen() {
        assertEquals("9", Solution().nearestPalindromic("10"))
    }

    @Test
    fun handlesSingleDigit() {
        assertEquals("0", Solution().nearestPalindromic("1"))
    }

    @Test
    fun choosesSmallerValueOnDistanceTie() {
        assertEquals("999", Solution().nearestPalindromic("1000"))
    }
}
