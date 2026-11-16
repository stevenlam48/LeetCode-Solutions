package minimuminsertionstepstomakeastringpalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumInsertionStepsToMakeAStringPalindromeTest {
    private val solution = Solution()

    @Test
    fun alreadyPalindrome() {
        assertEquals(0, solution.minInsertions("zzazz"))
    }

    @Test
    fun interleavedPalindromicSubsequence() {
        assertEquals(2, solution.minInsertions("mbadm"))
    }

    @Test
    fun leetcodeExample() {
        assertEquals(5, solution.minInsertions("leetcode"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.minInsertions(""))
    }

    @Test
    fun twoDistinctCharacters() {
        assertEquals(1, solution.minInsertions("ab"))
    }
}
