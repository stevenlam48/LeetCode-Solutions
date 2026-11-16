package minimumoperationstomakearotatedpalindromeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeARotatedPalindromeIiTest {
    @Test
    fun testPalindromeWithRepeatedCharacters() {
        assertEquals(0, Solution().minOperations("aa"))
    }

    @Test
    fun testTwoDistinctCharacters() {
        assertEquals(1, Solution().minOperations("ab"))
    }

    @Test
    fun testRotationCreatesPalindrome() {
        assertEquals(1, Solution().minOperations("aabb"))
    }

    @Test
    fun testThreeDistinctCharacters() {
        assertEquals(2, Solution().minOperations("abc"))
    }
}
