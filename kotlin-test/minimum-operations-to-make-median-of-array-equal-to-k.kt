package minimumoperationstomakemedianofarrayequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeMedianOfArrayEqualToKTest {
    @Test
    fun example() {
        assertEquals(2L, Solution().minOperationsToMakeMedianK(intArrayOf(2, 5, 6, 8, 5), 4))
    }

    @Test
    fun medianAlreadyK() {
        assertEquals(0L, Solution().minOperationsToMakeMedianK(intArrayOf(1, 2, 3, 4, 5), 3))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().minOperationsToMakeMedianK(intArrayOf(1), 1))
        assertEquals(9L, Solution().minOperationsToMakeMedianK(intArrayOf(1), 10))
    }

    @Test
    fun raiseLargeMedian() {
        assertEquals(15L, Solution().minOperationsToMakeMedianK(intArrayOf(1, 2, 3), 10))
    }
}
