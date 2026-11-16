package maximumpartitionfactor

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPartitionFactorTest {
    @Test
    fun triangle() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0))
        assertEquals(2, Solution().maxPartitionFactor(points))
    }

    @Test
    fun square() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 3), intArrayOf(3, 0), intArrayOf(3, 3))
        assertEquals(6, Solution().maxPartitionFactor(points))
    }

    @Test
    fun fewerThanThreePoints() {
        assertEquals(0, Solution().maxPartitionFactor(arrayOf(intArrayOf(0, 0), intArrayOf(5, 5))))
        assertEquals(0, Solution().maxPartitionFactor(arrayOf(intArrayOf(2, 7))))
    }

    @Test
    fun collinearPoints() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0))
        assertEquals(2, Solution().maxPartitionFactor(points))
    }
}
