package incrementalevenweightedcyclequeries

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IncrementalEvenWeightedCycleQueriesTest {
    @Test
    fun evenCycle() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 2, 0)
        )
        assertEquals(3, Solution().numberOfEdgesAdded(3, edges))
    }

    @Test
    fun oddCycle() {
        val edges = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 2, 1)
        )
        assertEquals(2, Solution().numberOfEdgesAdded(3, edges))
    }

    @Test
    fun noEdges() {
        assertEquals(0, Solution().numberOfEdgesAdded(1, emptyArray()))
    }

    @Test
    fun parallelEdges() {
        val even = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0)
        )
        assertEquals(2, Solution().numberOfEdgesAdded(2, even))

        val odd = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 0)
        )
        assertEquals(1, Solution().numberOfEdgesAdded(2, odd))
    }
}
