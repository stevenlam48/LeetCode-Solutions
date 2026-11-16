package minimumoperationstomakearotatedpalindromei

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeARotatedPalindromeITest {

    @Test
    fun testSingleCharacter() {
        assertEquals(0, Solution().minOperations("a"))
    }

    @Test
    fun testAlreadyPalindrome() {
        assertEquals(0, Solution().minOperations("abcba"))
        assertEquals(0, Solution().minOperations("abba"))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals(1, Solution().minOperations("ab"))
        assertEquals(1, Solution().minOperations("az"))
    }

    @Test
    fun testThreeCharacters() {
        assertEquals(2, Solution().minOperations("abc"))
        assertEquals(2, Solution().minOperations("xyz"))
    }

    @Test
    fun testFourCharacters() {
        assertEquals(3, Solution().minOperations("abcd"))
    }

    @Test
    fun testRepeatedCharacters() {
        assertEquals(0, Solution().minOperations("aaaa"))
    }

    @Test
    fun testLongerString() {
        assertEquals(20, Solution().minOperations("leetcode"))
    }
}
