package longestunequaladjacentgroupssubsequenceii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestUnequalAdjacentGroupsSubsequenceIITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(
            listOf("bab", "cab"),
            solution.getWordsInLongestSubsequence(
                3, arrayOf("bab", "dab", "cab"), intArrayOf(1, 2, 2)
            )
        )
    }

    @Test
    fun testExampleTwo() {
        assertEquals(
            listOf("a", "b", "c", "d"),
            solution.getWordsInLongestSubsequence(
                4, arrayOf("a", "b", "c", "d"), intArrayOf(1, 2, 3, 4)
            )
        )
    }

    @Test
    fun testSingleWord() {
        assertEquals(
            listOf("x"),
            solution.getWordsInLongestSubsequence(1, arrayOf("x"), intArrayOf(0))
        )
    }

    @Test
    fun testDifferentLengthsCannotChain() {
        assertEquals(
            listOf("a"),
            solution.getWordsInLongestSubsequence(
                3, arrayOf("a", "ab", "abc"), intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun testTwoCharacterDifferenceRejected() {
        assertEquals(
            listOf("abc"),
            solution.getWordsInLongestSubsequence(
                2, arrayOf("abc", "xyz"), intArrayOf(1, 2)
            )
        )
    }

    @Test
    fun testAlternatingGroups() {
        assertEquals(
            listOf("a", "b", "c", "d"),
            solution.getWordsInLongestSubsequence(
                4, arrayOf("a", "b", "c", "d"), intArrayOf(1, 2, 1, 2)
            )
        )
    }
}
