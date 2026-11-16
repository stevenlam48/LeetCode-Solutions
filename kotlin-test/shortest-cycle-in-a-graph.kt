package shortestcycleinagraph

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestCycleInAGraphTest {
    @Test
    fun findsTriangle() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0))
        assertEquals(3, Solution().findShortestCycle(3, edges))
    }

    @Test
    fun findsEvenCycle() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 0))
        assertEquals(4, Solution().findShortestCycle(4, edges))
    }

    @Test
    fun returnsMinusOneForAcyclicGraph() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))
        assertEquals(-1, Solution().findShortestCycle(4, edges))
        assertEquals(-1, Solution().findShortestCycle(3, emptyArray()))
    }

    @Test
    fun selectsShortestAcrossDifferentLengths() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0),
            intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(5, 2)
        )
        assertEquals(3, Solution().findShortestCycle(6, edges))
    }
}
