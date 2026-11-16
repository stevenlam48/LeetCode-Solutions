package validkuniquesubarraysi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidKUniqueSubarraysITest {
    @Test
    fun leetCodeExample() {
        val nums = intArrayOf(1, 2, 1, 2)
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2))
        assertEquals(
            listOf(true, false, false, false),
            Solution().validSubarrays(nums, 2, queries)
        )
    }

    @Test
    fun kEqualsOne() {
        val nums = intArrayOf(1, 1, 1, 2, 2)
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(3, 4), intArrayOf(0, 3))
        assertEquals(
            listOf(false, true, true, false),
            Solution().validSubarrays(nums, 1, queries)
        )
    }

    @Test
    fun threeDistinctValues() {
        val nums = intArrayOf(1, 2, 2, 1, 3, 3)
        val queries = arrayOf(
            intArrayOf(0, 3), intArrayOf(0, 5), intArrayOf(2, 5), intArrayOf(4, 5), intArrayOf(1, 4)
        )
        assertEquals(
            listOf(true, false, false, false, false),
            Solution().validSubarrays(nums, 2, queries)
        )
    }

    @Test
    fun singleElementQueries() {
        val nums = intArrayOf(5, 5)
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(0, 1))
        assertEquals(
            listOf(false, false, true),
            Solution().validSubarrays(nums, 1, queries)
        )
    }
}
