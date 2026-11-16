package longestcommonprefixofkstringsafterremoval

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixOfKStringsAfterRemovalTest {
    private val solution = Solution()

    @Test
    fun mixedWords() {
        assertArrayEquals(
            intArrayOf(3, 4, 4, 3, 4),
            solution.longestCommonPrefix(arrayOf("jump", "run", "run", "jump", "run"), 2)
        )
    }

    @Test
    fun allButOneRequired() {
        assertArrayEquals(
            intArrayOf(3, 3, 3),
            solution.longestCommonPrefix(arrayOf("abcd", "abce", "abcf"), 2)
        )
    }

    @Test
    fun removingWordLeavesBestPair() {
        assertArrayEquals(
            intArrayOf(2, 3, 2),
            solution.longestCommonPrefix(arrayOf("abcd", "abzz", "abce"), 2)
        )
    }

    @Test
    fun noCommonPrefix() {
        assertArrayEquals(
            intArrayOf(0, 0, 0),
            solution.longestCommonPrefix(arrayOf("a", "b", "c"), 2)
        )
    }
}
