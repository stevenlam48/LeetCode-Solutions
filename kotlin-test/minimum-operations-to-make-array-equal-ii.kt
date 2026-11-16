package minimumoperationstomakearrayequalii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayEqualIiTest {
    @Test
    fun testBalancedIncreasesAndDecreases() {
        assertEquals(
            2L,
            Solution().minOperations(
                intArrayOf(4, 3, 1, 4),
                intArrayOf(1, 3, 7, 1),
                3
            )
        )
    }

    @Test
    fun testZeroStepWithAlreadyEqualArrays() {
        assertEquals(0L, Solution().minOperations(intArrayOf(1, 2), intArrayOf(1, 2), 0))
    }

    @Test
    fun testDifferenceNotDivisibleByStep() {
        assertEquals(-1L, Solution().minOperations(intArrayOf(1), intArrayOf(3), 3))
    }

    @Test
    fun testUnbalancedOperations() {
        assertEquals(
            -1L,
            Solution().minOperations(intArrayOf(1, 2, 3), intArrayOf(2, 1, 4), 1)
        )
    }
}
