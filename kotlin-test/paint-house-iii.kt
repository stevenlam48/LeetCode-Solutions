package painthouseiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintHouseIiiTest {
    private val solution = Solution()
    private val cost = arrayOf(
        intArrayOf(1, 10), intArrayOf(10, 1), intArrayOf(10, 1),
        intArrayOf(1, 10), intArrayOf(5, 1)
    )

    @Test
    fun examples() {
        assertEquals(9, solution.minCost(intArrayOf(0, 0, 0, 0, 0), cost, 5, 2, 3))
        assertEquals(11, solution.minCost(intArrayOf(0, 2, 1, 2, 0), cost, 5, 2, 3))
        assertEquals(23, solution.minCost(intArrayOf(0, 0, 0, 0, 0), cost, 5, 2, 5))
    }

    @Test
    fun impossibleTarget() {
        val cost = Array(4) { intArrayOf(1, 1, 1) }
        assertEquals(-1, solution.minCost(intArrayOf(3, 1, 2, 3), cost, 4, 3, 3))
    }

    @Test
    fun singleHouse() {
        assertEquals(2, solution.minCost(intArrayOf(0), arrayOf(intArrayOf(2, 4)), 1, 2, 1))
        assertEquals(0, solution.minCost(intArrayOf(2), arrayOf(intArrayOf(2, 4)), 1, 2, 1))
    }
}
