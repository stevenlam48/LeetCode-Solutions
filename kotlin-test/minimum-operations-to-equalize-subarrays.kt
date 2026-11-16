package minimumoperationstoequalizesubarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToEqualizeSubarraysTest {

    @Test
    fun testWholeArray() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val queries = arrayOf(intArrayOf(0, 4))
        assertEquals(listOf(6L), Solution().minOperations(nums, 1, queries))
    }

    @Test
    fun testMultipleQueries() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val queries = arrayOf(
            intArrayOf(0, 4),
            intArrayOf(1, 3),
            intArrayOf(0, 0)
        )
        assertEquals(listOf(6L, 2L, 0L), Solution().minOperations(nums, 1, queries))
    }

    @Test
    fun testDifferentRemainders() {
        val nums = intArrayOf(1, 2, 3)
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(0, 1),
            intArrayOf(2, 2)
        )
        assertEquals(listOf(-1L, -1L, 0L), Solution().minOperations(nums, 2, queries))
    }

    @Test
    fun testSameRemainder() {
        val nums = intArrayOf(2, 4, 6)
        val queries = arrayOf(intArrayOf(0, 2))
        assertEquals(listOf(2L), Solution().minOperations(nums, 2, queries))
    }

    @Test
    fun testAlreadyEqual() {
        val nums = intArrayOf(4, 4, 4)
        val queries = arrayOf(intArrayOf(0, 2))
        assertEquals(listOf(0L), Solution().minOperations(nums, 3, queries))
    }

    @Test
    fun testSingleElementQueries() {
        val nums = intArrayOf(7, 9, 11)
        val queries = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )
        assertEquals(listOf(0L, 0L, 0L), Solution().minOperations(nums, 2, queries))
    }
}
