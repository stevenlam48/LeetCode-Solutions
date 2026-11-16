package distinctgatepathstolca

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DistinctGatePathsToLcaTest {
    @Test
    fun testSingleNode() {
        val parent = intArrayOf(-1)
        val gates = arrayOf(intArrayOf(0, 0, 0))
        val queries = arrayOf(intArrayOf(0, 0, 0, 0))
        assertEquals(1, Solution().distinctPaths(1, parent, gates, queries))
    }

    @Test
    fun testTwoNodes() {
        val parent = intArrayOf(-1, 0)
        val gates = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 2, 3))
        val queries = arrayOf(intArrayOf(0, 0, 1, 0))
        assertEquals(5, Solution().distinctPaths(2, parent, gates, queries))
    }

    @Test
    fun testSameNodeQuery() {
        val parent = intArrayOf(-1, 0)
        val gates = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 2, 3))
        val queries = arrayOf(intArrayOf(1, 1, 1, 1))
        assertEquals(1, Solution().distinctPaths(2, parent, gates, queries))
    }

    @Test
    fun testXorOfQueries() {
        val parent = intArrayOf(-1, 0)
        val gates = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 2, 3))
        val queries = arrayOf(
            intArrayOf(0, 0, 1, 0),
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals(4, Solution().distinctPaths(2, parent, gates, queries))
    }

    @Test
    fun testChain() {
        val parent = intArrayOf(-1, 0, 1)
        val gates = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 1)
        )
        val queries = arrayOf(intArrayOf(2, 0, 0, 0))
        assertEquals(3, Solution().distinctPaths(3, parent, gates, queries))
    }
}
