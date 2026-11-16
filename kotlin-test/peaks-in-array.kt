package peaksinarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PeaksInArrayTest {
    private val solution = Solution()

    @Test
    fun testCountPeaks() {
        val nums = intArrayOf(3, 1, 4, 2, 5)
        val queries = arrayOf(intArrayOf(1, 0, 4))
        assertArrayEquals(intArrayOf(1), solution.countOfPeaks(nums, queries))
    }

    @Test
    fun testUpdateRemovesPeak() {
        val nums = intArrayOf(3, 1, 4, 2, 5)
        val queries = arrayOf(intArrayOf(2, 3, 4), intArrayOf(1, 0, 4))
        assertArrayEquals(intArrayOf(0), solution.countOfPeaks(nums, queries))
    }

    @Test
    fun testNoPeaks() {
        val nums = intArrayOf(1, 2, 3)
        val queries = arrayOf(intArrayOf(1, 0, 2))
        assertArrayEquals(intArrayOf(0), solution.countOfPeaks(nums, queries))
    }

    @Test
    fun testShortRanges() {
        val nums = intArrayOf(1, 3, 2)
        val queries = arrayOf(intArrayOf(1, 0, 2), intArrayOf(1, 1, 2), intArrayOf(1, 0, 1))
        assertArrayEquals(intArrayOf(1, 0, 0), solution.countOfPeaks(nums, queries))
    }
}
