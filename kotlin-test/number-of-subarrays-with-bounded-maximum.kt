package numberofsubarrayswithboundedmaximum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubarraysWithBoundedMaximumTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(3, solution.numSubarrayBoundedMax(intArrayOf(2, 1, 4, 3), 2, 3))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7, solution.numSubarrayBoundedMax(intArrayOf(2, 9, 2, 5, 6), 2, 8))
    }

    @Test
    fun noValidMaximum() {
        assertEquals(0, solution.numSubarrayBoundedMax(intArrayOf(1, 1, 9), 2, 3))
    }

    @Test
    fun empty() {
        assertEquals(0, solution.numSubarrayBoundedMax(intArrayOf(), 0, 2))
    }
}
