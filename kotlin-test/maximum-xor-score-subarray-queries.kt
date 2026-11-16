package maximumxorscoresubarrayqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumXorScoreSubarrayQueriesTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val nums = intArrayOf(2, 8, 4, 32, 16, 1)
        val queries = arrayOf(
            intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(0, 5), intArrayOf(3, 5)
        )
        assertArrayEquals(intArrayOf(12, 12, 60, 48), solution.maximumSubarrayXor(nums, queries))
    }

    @Test
    fun wholeSmallArray() {
        val nums = intArrayOf(1, 2, 3)
        val queries = arrayOf(intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(3), solution.maximumSubarrayXor(nums, queries))
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(0)
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(0), solution.maximumSubarrayXor(nums, queries))
    }

    @Test
    fun singleElementNonZero() {
        val nums = intArrayOf(7)
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(7), solution.maximumSubarrayXor(nums, queries))
    }
}
