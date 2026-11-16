package createcomponentswithsamevalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CreateComponentsWithSameValueTest {
    @Test
    fun `finds the maximum two deletable edges`() {
        val nums = intArrayOf(6, 2, 2, 2, 6)
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 4))
        assertEquals(2, Solution().componentValue(nums, edges))
    }

    @Test
    fun `a single node has no deletable edges`() {
        assertEquals(0, Solution().componentValue(intArrayOf(2), emptyArray()))
    }

    @Test
    fun `separates every leaf of a star`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertEquals(3, Solution().componentValue(nums, edges))
    }

    @Test
    fun `returns zero when equal components are impossible`() {
        val nums = intArrayOf(1, 2, 1)
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(0, Solution().componentValue(nums, edges))
    }
}
