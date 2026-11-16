package numberofsubarraysofsizekandaveragegreaterthanorequaltothreshold

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThresholdTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(3, solution.numOfSubarrays(intArrayOf(2, 2, 2, 2, 5, 5, 5, 8), 3, 4))
    }

    @Test
    fun exampleTwo() {
        assertEquals(6, solution.numOfSubarrays(intArrayOf(11, 13, 17, 23, 29, 31, 7, 5, 2, 3), 3, 5))
    }

    @Test
    fun singleElementWindow() {
        assertEquals(2, solution.numOfSubarrays(intArrayOf(4, 3, 5), 1, 4))
    }

    @Test
    fun thresholdIsInclusive() {
        assertEquals(3, solution.numOfSubarrays(intArrayOf(-2, 4, 2, 0), 2, 1))
    }
}
