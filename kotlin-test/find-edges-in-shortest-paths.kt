package findedgesinshortestpaths

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindEdgesInShortestPathsTest {
    @Test
    fun standardExample() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(0, 2, 1),
            intArrayOf(1, 3, 2),
            intArrayOf(1, 4, 3),
            intArrayOf(1, 5, 1),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 5, 3)
        )
        assertArrayEquals(
            booleanArrayOf(true, true, true, false, true, true, true),
            Solution().findAnswer(6, edges)
        )
    }

    @Test
    fun onlyDirectEdgeIsShortest() {
        val edges = arrayOf(
            intArrayOf(2, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 3, 1),
            intArrayOf(2, 3, 1)
        )
        assertArrayEquals(
            booleanArrayOf(false, false, true, false),
            Solution().findAnswer(4, edges)
        )
    }

    @Test
    fun singleEdge() {
        val edges = arrayOf(intArrayOf(0, 1, 5))
        assertArrayEquals(booleanArrayOf(true), Solution().findAnswer(2, edges))
    }

    @Test
    fun twoEqualShortestPaths() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 3, 1),
            intArrayOf(0, 2, 1),
            intArrayOf(2, 3, 1)
        )
        assertArrayEquals(
            booleanArrayOf(true, true, true, true),
            Solution().findAnswer(4, edges)
        )
    }
}
