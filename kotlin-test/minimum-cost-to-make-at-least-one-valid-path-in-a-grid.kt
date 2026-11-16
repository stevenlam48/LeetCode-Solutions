package minimumcosttomakeatleastonevalidpathinagrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMakeAtLeastOneValidPathInAGridTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1), intArrayOf(2, 2, 2, 2),
            intArrayOf(1, 1, 1, 1), intArrayOf(2, 2, 2, 2)
        )
        assertEquals(3, solution.minCost(grid))
    }

    @Test
    fun secondLeetCodeExample() {
        val grid = arrayOf(intArrayOf(1, 1, 3), intArrayOf(3, 2, 2), intArrayOf(1, 1, 4))
        assertEquals(0, solution.minCost(grid))
    }

    @Test
    fun thirdLeetCodeExample() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(4, 3))
        assertEquals(1, solution.minCost(grid))
    }

    @Test
    fun singleCell() {
        assertEquals(0, solution.minCost(arrayOf(intArrayOf(1))))
    }
}
