package maximumnumberofpointswithcost

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofpointswithcostTest {
    @Test
    fun example1() {
        val points = arrayOf(intArrayOf(1, 2, 3), intArrayOf(1, 5, 1), intArrayOf(3, 1, 1))
        assertEquals(9L, Solution().maxPoints(points))
    }

    @Test
    fun example2() {
        val points = arrayOf(intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(4, 2))
        assertEquals(11L, Solution().maxPoints(points))
    }

    @Test
    fun singleRow() {
        val points = arrayOf(intArrayOf(2, 4, 1))
        assertEquals(4L, Solution().maxPoints(points))
    }

    @Test
    fun singleColumn() {
        val points = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        assertEquals(6L, Solution().maxPoints(points))
    }
}
