package minimumdivisionoperationstomakearraynondecreasing
// Time:  precompute: O(r)
//        runtime:    O(n)
// Space: O(r) 

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDivisionOperationsToMakeArrayNonDecreasingTest {
    private val solution = Solution()

    @Test
    fun compositeValuesCanBeDividedOnce() {
        assertEquals(1, solution.minOperations(intArrayOf(12, 5, 10)))
        assertEquals(1, solution.minOperations(intArrayOf(14, 3, 14)))
        assertEquals(1, solution.minOperations(intArrayOf(15, 6, 7)))
    }

    @Test
    fun primeCannotBecomeSmallEnough() {
        assertEquals(-1, solution.minOperations(intArrayOf(7, 3, 6)))
        assertEquals(-1, solution.minOperations(intArrayOf(15, 2)))
    }

    @Test
    fun alreadyNonDecreasing() {
        assertEquals(0, solution.minOperations(intArrayOf(2, 8, 7, 5).also { it.sort() }))
        assertEquals(0, solution.minOperations(intArrayOf(4)))
        assertEquals(0, solution.minOperations(intArrayOf()))
    }
}
