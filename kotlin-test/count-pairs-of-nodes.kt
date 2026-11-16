package countpairsofnodes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsOfNodesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(1, 3),
            intArrayOf(2, 3), intArrayOf(3, 4)
        )
        assertArrayEquals(intArrayOf(6, 6), solution.countPairs(4, edges, intArrayOf(2, 3)))
    }

    @Test
    fun testSingleEdge() {
        val edges = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(1, 0), solution.countPairs(2, edges, intArrayOf(0, 1)))
    }

    @Test
    fun testNoEdges() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.countPairs(3, arrayOf(), intArrayOf(0, 1, 2)))
    }

    @Test
    fun testCustom() {
        val edges = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(3, 0, 0), solution.countPairs(3, edges, intArrayOf(0, 1, 2)))
    }

    @Test
    fun testEmptyQueries() {
        val edges = arrayOf(intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(), solution.countPairs(2, edges, intArrayOf()))
    }
}
