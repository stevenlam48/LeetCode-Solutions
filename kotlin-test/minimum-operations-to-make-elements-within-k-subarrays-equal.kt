package minimumoperationstomakeelementswithinksubarraysequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeElementsWithinKSubarraysEqualTest {
    @Test
    fun singleElementWindow() {
        assertEquals(0L, Solution().minOperations(intArrayOf(1), 1, 1))
        assertEquals(0L, Solution().minOperations(intArrayOf(7), 1, 1))
    }

    @Test
    fun oneWindowOfTwo() {
        assertEquals(2L, Solution().minOperations(intArrayOf(1, 3), 2, 1))
    }

    @Test
    fun twoDisjointWindows() {
        assertEquals(2L, Solution().minOperations(intArrayOf(1, 2, 3, 4), 2, 2))
    }

    @Test
    fun equalWindowCostsNothing() {
        assertEquals(0L, Solution().minOperations(intArrayOf(5, 5, 5, 5), 2, 2))
    }
}
