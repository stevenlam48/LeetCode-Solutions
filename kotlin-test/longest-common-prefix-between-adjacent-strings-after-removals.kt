package longestcommonprefixbetweenadjacentstringsafterremovals

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixBetweenAdjacentStringsAfterRemovalsTest {
    private val solution = Solution()

    @Test
    fun mixedWords() {
        assertArrayEquals(
            intArrayOf(3, 0, 0, 3, 3),
            solution.longestCommonPrefix(arrayOf("jump", "run", "run", "jump", "run"))
        )
    }

    @Test
    fun twoIdenticalWords() {
        assertArrayEquals(
            intArrayOf(0, 0),
            solution.longestCommonPrefix(arrayOf("same", "same"))
        )
    }

    @Test
    fun joinedPairHasLongPrefix() {
        assertArrayEquals(
            intArrayOf(0, 3, 0),
            solution.longestCommonPrefix(arrayOf("abcx", "z", "abcy"))
        )
    }

    @Test
    fun emptyStrings() {
        assertArrayEquals(
            intArrayOf(0, 0, 0),
            solution.longestCommonPrefix(arrayOf("", "abc", ""))
        )
    }
}
