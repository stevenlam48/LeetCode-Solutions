package countdistinctsubarraysdivisiblebykinsortedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDistinctSubarraysDivisibleByKInSortedArrayTest {
    @Test
    fun example() {
        assertEquals(3L, Solution().numGoodSubarrays(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun allEqual() {
        assertEquals(3L, Solution().numGoodSubarrays(intArrayOf(2, 2, 2), 2))
        assertEquals(2L, Solution().numGoodSubarrays(intArrayOf(2, 2, 2, 2, 2, 2), 6))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(3L, Solution().numGoodSubarrays(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun withZero() {
        assertEquals(3L, Solution().numGoodSubarrays(intArrayOf(4, 5, 0), 3))
    }

    @Test
    fun singleElement() {
        assertEquals(1L, Solution().numGoodSubarrays(intArrayOf(7), 7))
        assertEquals(0L, Solution().numGoodSubarrays(intArrayOf(7), 5))
    }

    @Test
    fun empty() {
        assertEquals(0L, Solution().numGoodSubarrays(intArrayOf(), 3))
    }
}
