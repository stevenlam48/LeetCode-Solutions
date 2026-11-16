package longestunequaladjacentgroupssubsequencei

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestUnequalAdjacentGroupsSubsequenceITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(
            listOf("e", "b"),
            solution.getWordsInLongestSubsequence(
                3, arrayOf("e", "a", "b"), intArrayOf(0, 0, 1)
            )
        )
    }

    @Test
    fun testExampleTwo() {
        assertEquals(
            listOf("a", "b", "c"),
            solution.getWordsInLongestSubsequence(
                4, arrayOf("a", "b", "c", "d"), intArrayOf(1, 0, 1, 1)
            )
        )
    }

    @Test
    fun testSingleWord() {
        assertEquals(
            listOf("x"),
            solution.getWordsInLongestSubsequence(1, arrayOf("x"), intArrayOf(5))
        )
    }

    @Test
    fun testAllSameGroup() {
        assertEquals(
            listOf("a"),
            solution.getWordsInLongestSubsequence(
                3, arrayOf("a", "b", "c"), intArrayOf(2, 2, 2)
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
