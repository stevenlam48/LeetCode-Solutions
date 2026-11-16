package primepalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimePalindromeTest {
    @Test
    fun exampleOne() {
        assertEquals(7, Solution().primePalindrome(6))
    }

    @Test
    fun exampleTwo() {
        assertEquals(11, Solution().primePalindrome(8))
    }

    @Test
    fun exampleThree() {
        assertEquals(101, Solution().primePalindrome(13))
    }

    @Test
    fun one() {
        assertEquals(2, Solution().primePalindrome(1))
    }

    @Test
    fun two() {
        assertEquals(2, Solution().primePalindrome(2))
    }

    @Test
    fun hundred() {
        assertEquals(101, Solution().primePalindrome(100))
    }
}
