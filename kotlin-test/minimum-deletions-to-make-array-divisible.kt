package minimumdeletionstomakearraydivisible
// Time:  O(n + m + logr), r is max(numsDivide)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeArrayDivisibleTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(2, solution.minOperations(intArrayOf(2, 3, 2, 4, 3), intArrayOf(9, 6, 9, 3, 15)))
        assertEquals(-1, solution.minOperations(intArrayOf(4, 3, 6), intArrayOf(8, 2, 6, 10)))
    }

    @Test
    fun smallestElementAlreadyDividesGcd() {
        assertEquals(0, solution.minOperations(intArrayOf(1, 3, 4), intArrayOf(2, 4, 6)))
    }

    @Test
    fun duplicateSmallestElementsAreRemovedTogether() {
        assertEquals(3, solution.minOperations(intArrayOf(5, 5, 5, 6), intArrayOf(12, 18)))
    }
}
