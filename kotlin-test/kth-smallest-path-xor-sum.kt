package kthsmallestpathxorsum

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KthSmallestPathXorSumTest {
    @Test
    fun branchedTreeAndMissingRanks() {
        val result = Solution().kthSmallest(
            intArrayOf(-1, 0, 0, 1),
            intArrayOf(1, 2, 3, 4),
            arrayOf(
                intArrayOf(0, 1), intArrayOf(0, 4), intArrayOf(1, 1),
                intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(3, 5)
            )
        )
        assertArrayEquals(intArrayOf(1, 7, 3, 7, -1, -1), result)
    }

    @Test
    fun duplicatePathValuesUseDistinctSet() {
        val result = Solution().kthSmallest(
            intArrayOf(-1, 0, 1),
            intArrayOf(5, 3, 3),
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2))
        )
        assertArrayEquals(intArrayOf(5, 6, -1, 6), result)
    }

    @Test
    fun singleNode() {
        val result = Solution().kthSmallest(
            intArrayOf(-1),
            intArrayOf(9),
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        )
        assertArrayEquals(intArrayOf(9, -1), result)
    }

    @Test
    fun multipleChildrenExerciseMerging() {
        val result = Solution().kthSmallest(
            intArrayOf(-1, 0, 0, 0, 1, 1, 2),
            intArrayOf(8, 2, 4, 1, 3, 5, 7),
            arrayOf(intArrayOf(0, 2), intArrayOf(0, 5), intArrayOf(1, 3), intArrayOf(2, 2))
        )
        assertArrayEquals(intArrayOf(9, 12, 15, 12), result)
    }
}
