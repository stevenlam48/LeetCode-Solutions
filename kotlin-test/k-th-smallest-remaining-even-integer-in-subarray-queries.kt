package kthsmallestremainingevenintegerinsubarrayqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KthSmallestRemainingEvenIntegerInSubarrayQueriesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 6, 6),
            solution.kthRemainingInteger(
                intArrayOf(1, 4, 7),
                arrayOf(intArrayOf(0, 2, 1), intArrayOf(1, 1, 2), intArrayOf(0, 0, 3))
            )
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(6, 2, 12),
            solution.kthRemainingInteger(
                intArrayOf(2, 5, 8),
                arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 1), intArrayOf(0, 2, 4))
            )
        )
    }

    @Test
    fun example3() {
        assertArrayEquals(
            intArrayOf(2, 8),
            solution.kthRemainingInteger(
                intArrayOf(3, 6),
                arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 1, 3))
            )
        )
    }

    @Test
    fun allEvensRemoved() {
        assertArrayEquals(
            intArrayOf(8, 12),
            solution.kthRemainingInteger(
                intArrayOf(2, 4, 6),
                arrayOf(intArrayOf(0, 2, 1), intArrayOf(0, 2, 3))
            )
        )
    }

    @Test
    fun singleLargeEven() {
        assertArrayEquals(
            intArrayOf(2, 12),
            solution.kthRemainingInteger(
                intArrayOf(10),
                arrayOf(intArrayOf(0, 0, 1), intArrayOf(0, 0, 5))
            )
        )
    }

    @Test
    fun noEvensInRange() {
        assertArrayEquals(
            intArrayOf(2, 4),
            solution.kthRemainingInteger(
                intArrayOf(1, 3, 5),
                arrayOf(intArrayOf(0, 2, 1), intArrayOf(0, 2, 2))
            )
        )
    }
}
