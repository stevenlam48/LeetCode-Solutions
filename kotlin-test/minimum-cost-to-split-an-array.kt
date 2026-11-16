package minimumcosttosplitanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToSplitAnArrayTest {
    @Test
    fun example1() {
        assertEquals(6, Solution().minCost(intArrayOf(1, 2, 1, 2, 1), 2))
    }

    @Test
    fun allSame() {
        assertEquals(7, Solution().minCost(intArrayOf(1, 1, 1, 1), 3))
    }

    @Test
    fun allDistinct() {
        assertEquals(1, Solution().minCost(intArrayOf(0, 1, 2), 1))
    }

    @Test
    fun pairs() {
        assertEquals(6, Solution().minCost(intArrayOf(1, 1, 2, 2), 2))
    }

    @Test
    fun single() {
        assertEquals(5, Solution().minCost(intArrayOf(0), 5))
    }
}
