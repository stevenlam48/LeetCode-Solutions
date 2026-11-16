package minimumsubarraylengthwithdistinctsumatleastk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSubarrayLengthWithDistinctSumAtLeastKTest {
    @Test
    fun repeatedValuesWithinWindow() {
        assertEquals(2, Solution().minLength(intArrayOf(1, 2, 2, 3, 1), 4))
    }

    @Test
    fun distinctSumBelowK() {
        assertEquals(-1, Solution().minLength(intArrayOf(2, 2, 2, 2), 5))
    }

    @Test
    fun entireArrayRequired() {
        assertEquals(3, Solution().minLength(intArrayOf(1, 2, 3), 6))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().minLength(intArrayOf(5), 5))
    }

    @Test
    fun duplicateRemovalsPreserveDistinctSum() {
        assertEquals(2, Solution().minLength(intArrayOf(2, 1, 1, 1), 3))
    }
}
