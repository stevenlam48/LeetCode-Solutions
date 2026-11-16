package findthelargestpalindromedivisiblebyk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLargestPalindromeDivisibleByKTest {
    @Test
    fun example1() {
        assertEquals("595", Solution().largestPalindrome(3, 5))
    }

    @Test
    fun example2() {
        assertEquals("8", Solution().largestPalindrome(1, 4))
    }

    @Test
    fun example3() {
        assertEquals("89898", Solution().largestPalindrome(5, 6))
    }

    @Test
    fun divisibleByTwo() {
        assertEquals("88", Solution().largestPalindrome(2, 2))
    }

    @Test
    fun divisibleByOne() {
        assertEquals("9", Solution().largestPalindrome(1, 1))
    }

    @Test
    fun divisibleBySeven() {
        assertEquals("9779", Solution().largestPalindrome(4, 7))
    }

    @Test
    fun longDivisibleBySeven() {
        assertEquals("999999999999", Solution().largestPalindrome(12, 7))
    }

    @Test
    fun divisibleByThree() {
        assertEquals("99999999", Solution().largestPalindrome(8, 3))
    }

    @Test
    fun oddDivisibleBySeven() {
        assertEquals("9994999", Solution().largestPalindrome(7, 7))
    }

    @Test
    fun evenDivisibleBySix() {
        assertEquals("897798", Solution().largestPalindrome(6, 6))
    }

    @Test
    fun shortDivisibleBySix() {
        assertEquals("8778", Solution().largestPalindrome(4, 6))
    }
}
