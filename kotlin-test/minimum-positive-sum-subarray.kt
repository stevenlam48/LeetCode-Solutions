package minimumpositivesumsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPositiveSumSubarrayTest {
    private val solution = Solution()

    @Test
    fun mixedValuesFindSmallestPositiveWindow() {
        assertEquals(1, solution.minimumSumSubarray(intArrayOf(3, -2, 1, 4), 2, 3))
    }

    @Test
    fun noPositiveWindowReturnsMinusOne() {
        assertEquals(-1, solution.minimumSumSubarray(intArrayOf(-2, 2, -3, 1), 2, 3))
    }

    @Test
    fun positiveValuesUseShortestWindow() {
        assertEquals(3, solution.minimumSumSubarray(intArrayOf(1, 2, 3, 4), 2, 4))
    }

    @Test
    fun singleElementWindowIsAllowed() {
        assertEquals(5, solution.minimumSumSubarray(intArrayOf(5), 1, 1))
    }

    @Test
    fun longerWindowCanProvideOnlyPositiveSum() {
        assertEquals(1, solution.minimumSumSubarray(intArrayOf(-5, 2, 3, -4), 2, 3))
    }
}
