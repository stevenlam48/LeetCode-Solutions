package blockplacementqueries

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BlockPlacementQueriesTest {
    @Test
    fun example1() {
        val queries = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3, 3),
            intArrayOf(2, 3, 1),
            intArrayOf(2, 2, 2)
        )
        assertEquals(listOf(false, true, true), Solution().getResults(queries))
    }

    @Test
    fun gapBetweenObstacles() {
        val queries = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 4, 2),
            intArrayOf(2, 4, 3)
        )
        assertEquals(listOf(true, false), Solution().getResults(queries))
    }

    @Test
    fun noObstacles() {
        val queries = arrayOf(intArrayOf(2, 5, 3))
        assertEquals(listOf(true), Solution().getResults(queries))
    }

    @Test
    fun obstacleAtZero() {
        val queries = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0, 1)
        )
        assertEquals(listOf(false), Solution().getResults(queries))
    }
}
