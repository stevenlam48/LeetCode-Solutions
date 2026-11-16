package longestpalindromicpathingraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestPalindromicPathInGraphTest {
    @Test
    fun pathPalindrome() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(3, Solution().maxLen(3, edges, "aba"))
    }

    @Test
    fun starNoPalindrome() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertEquals(1, Solution().maxLen(3, edges, "abc"))
    }

    @Test
    fun longerPath() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(4, Solution().maxLen(4, edges, "abba"))
    }

    @Test
    fun completeGraph() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))
        assertEquals(3, Solution().maxLen(3, edges, "aba"))
    }

    @Test
    fun completeGraphNoPair() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))
        assertEquals(1, Solution().maxLen(3, edges, "abc"))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().maxLen(1, emptyArray(), "z"))
    }
}
