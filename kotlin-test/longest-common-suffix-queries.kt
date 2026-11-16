package longestcommonsuffixqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LongestCommonSuffixQueriesTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(1, 1, 1),
            solution.stringIndices(
                arrayOf("abcd", "bcd", "xbcd"),
                arrayOf("cd", "bcd", "xyz")
            )
        )
    }

    @Test
    fun shortestThenEarliestWins() {
        assertArrayEquals(
            intArrayOf(1, 2, 2),
            solution.stringIndices(
                arrayOf("longabc", "abc", "bc"),
                arrayOf("abc", "zzbc", "none")
            )
        )
    }

    @Test
    fun equalLengthUsesFirstIndex() {
        assertArrayEquals(
            intArrayOf(0),
            solution.stringIndices(arrayOf("ab", "cb"), arrayOf("b"))
        )
    }

    @Test
    fun emptyContainerWord() {
        assertArrayEquals(
            intArrayOf(0),
            solution.stringIndices(arrayOf(""), arrayOf("anything"))
        )
    }
}
