package longestcommonsubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"))
    }

    @Test
    fun identicalStrings() {
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"))
    }

    @Test
    fun noCommonCharacters() {
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(5, solution.longestCommonSubsequence("aaabb", "aababb"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.longestCommonSubsequence("", "abc"))
    }
}
