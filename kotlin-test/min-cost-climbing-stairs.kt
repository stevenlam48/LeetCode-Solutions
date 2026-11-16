package mincostclimbingstairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinCostClimbingStairsTest {
    @Test
    fun example1() {
        assertEquals(15, Solution().minCostClimbingStairs(intArrayOf(10, 15, 20)))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
    }

    @Test
    fun twoZeroCosts() {
        assertEquals(0, Solution().minCostClimbingStairs(intArrayOf(0, 0)))
    }

    @Test
    fun singleStepCanBeSkipped() {
        assertEquals(0, Solution().minCostClimbingStairs(intArrayOf(5)))
    }
}
