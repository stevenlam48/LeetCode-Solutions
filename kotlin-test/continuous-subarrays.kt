package continuoussubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContinuousSubarraysTest {
    @Test
    fun leetCodeFirstExample() {
        assertEquals(8L, Solution().continuousSubarrays(intArrayOf(5, 4, 2, 4)))
    }

    @Test
    fun leetCodeSecondExample() {
        assertEquals(6L, Solution().continuousSubarrays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allValuesWithinTwoOfTheirNeighborsAreNotAllContinuous() {
        assertEquals(9L, Solution().continuousSubarrays(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun singletonAndDiscontinuousPair() {
        assertEquals(1L, Solution().continuousSubarrays(intArrayOf(1)))
        assertEquals(2L, Solution().continuousSubarrays(intArrayOf(1, 4)))
    }
}
