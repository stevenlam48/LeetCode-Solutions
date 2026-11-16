package minimumtimeforkconnectedcomponents

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeForKConnectedComponentsTest {
    private val solution = Solution()

    @Test
    fun testPathGraph() {
        val edges = arrayOf(
            intArrayOf(0, 1, 5),
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 2)
        )
        assertEquals(3, solution.minTime(4, edges, 3))
        assertEquals(2, solution.minTime(4, edges, 2))
        assertEquals(0, solution.minTime(4, edges, 1))
    }

    @Test
    fun testCycleGraph() {
        val edges = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 2),
            intArrayOf(3, 0, 1)
        )
        assertEquals(3, solution.minTime(4, edges, 3))
        assertEquals(2, solution.minTime(4, edges, 2))
        assertEquals(0, solution.minTime(4, edges, 1))
    }

    @Test
    fun testNoEdges() {
        assertEquals(0, solution.minTime(3, emptyArray(), 3))
        assertEquals(0, solution.minTime(3, emptyArray(), 1))
    }
}
