package constrainedsubsetsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstrainedSubsetSumTest {
    @Test
    fun matchesLeetCodeExample() {
        assertEquals(37, Solution().constrainedSubsetSum(intArrayOf(10, 2, -10, 5, 20), 2))
    }

    @Test
    fun allNegativeValuesRequireOneElement() {
        assertEquals(-1, Solution().constrainedSubsetSum(intArrayOf(-1, -2, -3), 1))
        assertEquals(-5, Solution().constrainedSubsetSum(intArrayOf(-10, -5), 2))
    }

    @Test
    fun allowsSkipsWithinDistanceLimit() {
        assertEquals(8, Solution().constrainedSubsetSum(intArrayOf(1, -2, 3, 4, -5), 2))
    }

    @Test
    fun excludesPredecessorsBeyondDistanceLimit() {
        assertEquals(2, Solution().constrainedSubsetSum(intArrayOf(1, -100, 2), 1))
    }
}
