package palindromicpathqueriesinatree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PalindromicPathQueriesInATreeTest {
    @Test
    fun testPathWithThreeDistinctCharacters() {
        val n = 6
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        val queries = listOf(
            "query 1 3",
            "query 1 1",
            "query 2 4",
            "update 2 b",
            "update 2 a",
            "query 1 3",
            "query 1 5"
        )
        val result = Solution().palindromePath(n, edges, "xabcdz", queries)
        assertEquals(listOf(false, true, false, true, false), result)
    }

    @Test
    fun testPalindromicPathsAndUpdates() {
        val n = 4
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        val queries = listOf(
            "query 1 3",
            "query 1 1",
            "update 2 a",
            "query 1 3",
            "update 3 c",
            "query 1 3"
        )
        val result = Solution().palindromePath(n, edges, "xaba", queries)
        assertEquals(listOf(true, true, true, true), result)
    }

    @Test
    fun testTwoNodePath() {
        val n = 3
        val edges = arrayOf(intArrayOf(1, 2))
        val queries = listOf(
            "query 1 2",
            "update 2 a",
            "query 1 2"
        )
        val result = Solution().palindromePath(n, edges, "xab", queries)
        assertEquals(listOf(false, true), result)
    }
}
