package peaksinarrayii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PeaksInArrayIiTest {
    private val solution = Solution()

    @Test
    fun testWholeRange() {
        val nums = intArrayOf(1, 3, 2, 5, 4)
        val queries = arrayOf(intArrayOf(1, 0, 4))
        assertEquals(listOf(5L), solution.countOfPeaks(nums, queries))
    }

    @Test
    fun testSubRange() {
        val nums = intArrayOf(1, 3, 2, 5, 4)
        val queries = arrayOf(intArrayOf(1, 1, 4))
        assertEquals(listOf(2L), solution.countOfPeaks(nums, queries))
    }

    @Test
    fun testUpdateThenQuery() {
        val nums = intArrayOf(1, 3, 2, 5, 4)
        val queries = arrayOf(intArrayOf(2, 1, 2), intArrayOf(1, 0, 4))
        assertEquals(listOf(3L), solution.countOfPeaks(nums, queries))
    }

    @Test
    fun testNoPeaks() {
        val nums = intArrayOf(3, 2, 1)
        val queries = arrayOf(intArrayOf(1, 0, 2))
        assertEquals(listOf(0L), solution.countOfPeaks(nums, queries))
    }
}
