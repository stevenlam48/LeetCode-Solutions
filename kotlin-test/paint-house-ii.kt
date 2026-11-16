package painthouseii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PaintHouseIiTest {
    private val solution = Solution()

    @Test
    fun example() {
        val costs = arrayOf(intArrayOf(1, 5, 3), intArrayOf(2, 9, 4))
        assertEquals(5, solution.minCostII(costs))
    }

    @Test
    fun moreHousesAndColors() {
        val costs = arrayOf(
            intArrayOf(8, 2, 9, 7),
            intArrayOf(3, 6, 1, 5),
            intArrayOf(4, 8, 2, 7),
            intArrayOf(9, 3, 6, 1)
        )
        assertEquals(8, solution.minCostII(costs))
    }

    @Test
    fun edgeCases() {
        assertEquals(0, solution.minCostII(emptyArray()))
        assertEquals(4, solution.minCostII(arrayOf(intArrayOf(9, 4, 8))))
    }

    @Test
    fun duplicateMinimumCosts() {
        val costs = arrayOf(intArrayOf(1, 1, 5), intArrayOf(4, 4, 4), intArrayOf(2, 2, 2))
        assertEquals(7, solution.minCostII(costs))
    }
}
