package kclosestpointstoorigin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KClosestPointsToOriginTest {
    private fun distances(points: Array<IntArray>): Set<Int> =
        points.map { it[0] * it[0] + it[1] * it[1] }.toSet()

    @Test
    fun `selects single closest point`() {
        val result = Solution().kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1)
        assertEquals(setOf(8), distances(result))
    }

    @Test
    fun `selects two closest points`() {
        val result = Solution().kClosest(
            arrayOf(intArrayOf(3, 3), intArrayOf(5, -1), intArrayOf(-2, 4)), 2
        )
        assertEquals(setOf(18, 20), distances(result))
    }

    @Test
    fun `can return all points`() {
        val result = Solution().kClosest(arrayOf(intArrayOf(1, 0), intArrayOf(0, 2)), 2)
        assertEquals(setOf(1, 4), distances(result))
    }

    @Test
    fun `accepts either tied point`() {
        val result = Solution().kClosest(
            arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(2, 0)), 2
        )
        assertEquals(setOf(1), distances(result))
        assertTrue(result.all { it[0] * it[0] + it[1] * it[1] == 1 })
    }
}
