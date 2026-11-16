package palindromepermutation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromePermutationTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertTrue(solution.canPermutePalindrome("aab"))
        assertTrue(solution.canPermutePalindrome("carerac"))
        assertFalse(solution.canPermutePalindrome("code"))
    }

    @Test
    fun emptyAndSingleCharacter() {
        assertTrue(solution.canPermutePalindrome(""))
        assertTrue(solution.canPermutePalindrome("z"))
    }

    @Test
    fun oddFrequencyCounts() {
        assertFalse(solution.canPermutePalindrome("aaabbbcc"))
        assertTrue(solution.canPermutePalindrome("aaaabbbcc"))
    }
}
