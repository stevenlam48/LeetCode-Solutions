package minimumabsolutedifferencequeries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceQueriesTest {
    @Test
    fun example1() {
        val nums = intArrayOf(1, 3, 4, 8)
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(0, 3))
        assertArrayEquals(intArrayOf(2, 1, 4, 1), Solution().minDifference(nums, queries))
    }

    @Test
    fun example2() {
        val nums = intArrayOf(4, 5, 2, 2, 7, 10)
        val queries = arrayOf(intArrayOf(2, 3), intArrayOf(0, 2), intArrayOf(0, 5), intArrayOf(3, 5))
        assertArrayEquals(intArrayOf(-1, 1, 1, 3), Solution().minDifference(nums, queries))
    }

    @Test
    fun singleElement() {
        val nums = intArrayOf(1)
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(-1), Solution().minDifference(nums, queries))
    }

    @Test
    fun allSame() {
        val nums = intArrayOf(5, 5, 5)
        val queries = arrayOf(intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(-1), Solution().minDifference(nums, queries))
    }
}
