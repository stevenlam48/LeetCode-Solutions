package minimumcosttomakearrayequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMakeArrayEqualTest {
    private val solution = Solution()

    @Test
    fun leetCodeExample() {
        assertEquals(8L, solution.minCost(intArrayOf(1, 3, 5, 2), intArrayOf(2, 3, 1, 14)))
    }

    @Test
    fun equalValues() {
        assertEquals(0L, solution.minCost(intArrayOf(2, 2, 2), intArrayOf(1, 2, 3)))
    }

    @Test
    fun weightedMedianIsNotMiddleIndex() {
        assertEquals(2L, solution.minCost(intArrayOf(1, 2, 3), intArrayOf(1, 10, 1)))
    }

    @Test
    fun negativeValues() {
        assertEquals(14L, solution.minCost(intArrayOf(-3, 1, 4), intArrayOf(2, 2, 2)))
    }
}
