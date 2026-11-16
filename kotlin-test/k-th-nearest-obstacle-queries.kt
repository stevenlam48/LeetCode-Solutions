package kthnearestobstaclequeries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KThNearestObstacleQueriesTest {
    @Test
    fun `tracks second nearest obstacle after each query`() {
        assertArrayEquals(
            intArrayOf(-1, 7, 5, 3),
            Solution().resultsArray(
                arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(2, 3), intArrayOf(-3, 0)), 2
            )
        )
    }

    @Test
    fun `nearest obstacle for k one`() {
        assertArrayEquals(
            intArrayOf(10, 8, 6),
            Solution().resultsArray(arrayOf(intArrayOf(5, 5), intArrayOf(4, 4), intArrayOf(3, 3)), 1)
        )
    }

    @Test
    fun `waits until k obstacles have been seen`() {
        assertArrayEquals(
            intArrayOf(-1, -1, 3),
            Solution().resultsArray(arrayOf(intArrayOf(1, 2), intArrayOf(0, 1), intArrayOf(-1, 0)), 3)
        )
    }

    @Test
    fun `absolute coordinates and duplicate distances`() {
        assertArrayEquals(
            intArrayOf(-1, 1, 1),
            Solution().resultsArray(arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 2)), 2)
        )
    }

    @Test
    fun `empty queries return empty results`() {
        assertArrayEquals(intArrayOf(), Solution().resultsArray(emptyArray(), 2))
    }
}
