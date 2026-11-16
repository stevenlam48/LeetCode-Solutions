package minimumoperationstoreachtargetarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToReachTargetArrayTest {
    @Test
    fun alreadyEqual() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoDistinctMismatches() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
    }

    @Test
    fun repeatedMismatchValue() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 1, 1), intArrayOf(2, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().minOperations(intArrayOf(5), intArrayOf(9)))
    }
}
