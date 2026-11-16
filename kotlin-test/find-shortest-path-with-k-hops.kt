package findshortestpathwithkhops

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindShortestPathWithKHopsTest {
    @Test
    fun testWithoutHops() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3), intArrayOf(0, 2, 10))
        assertEquals(5, Solution().shortestPathWithHops(3, edges, 0, 2, 0))
    }

    @Test
    fun testWithOneHop() {
        val edges = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3), intArrayOf(0, 2, 10))
        assertEquals(0, Solution().shortestPathWithHops(3, edges, 0, 2, 1))
    }

    @Test
    fun testSameSourceAndDestination() {
        assertEquals(0, Solution().shortestPathWithHops(1, emptyArray(), 0, 0, 0))
    }

    @Test
    fun testDirectEdge() {
        val edges = arrayOf(intArrayOf(0, 1, 5))
        assertEquals(0, Solution().shortestPathWithHops(2, edges, 0, 1, 1))
    }
}
