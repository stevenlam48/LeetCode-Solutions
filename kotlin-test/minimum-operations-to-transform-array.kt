package minimumoperationstotransformarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToTransformArrayTest {
    @Test
    fun mixedDistancesIncludeFinalInsertion() {
        assertEquals(7L, Solution().minOperations(intArrayOf(2, 8, 5), intArrayOf(1, 7, 9)))
    }

    @Test
    fun negativeValuesAreHandled() {
        assertEquals(8L, Solution().minOperations(intArrayOf(-3, 2), intArrayOf(-5, 7)))
    }

    @Test
    fun singleElementCountsDistanceAndInsertion() {
        assertEquals(6L, Solution().minOperations(intArrayOf(4), intArrayOf(9)))
    }

    @Test
    fun zeroDistanceAndLargerDistancesAreSummed() {
        assertEquals(11L, Solution().minOperations(intArrayOf(5, 1, 9), intArrayOf(5, 4, 2)))
    }
}
