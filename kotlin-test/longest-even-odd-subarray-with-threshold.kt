package longestevenoddsubarraywiththreshold

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestEvenOddSubarrayWithThresholdTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.longestAlternatingSubarray(intArrayOf(3, 2, 5, 4), 7))
    }

    @Test
    fun startsWithEven() {
        assertEquals(4, solution.longestAlternatingSubarray(intArrayOf(2, 3, 4, 5), 5))
    }

    @Test
    fun valuesAboveThresholdResetRun() {
        assertEquals(2, solution.longestAlternatingSubarray(intArrayOf(2, 3, 8, 4, 5), 5))
    }

    @Test
    fun oddCannotStartSubarray() {
        assertEquals(0, solution.longestAlternatingSubarray(intArrayOf(3, 5, 7), 7))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.longestAlternatingSubarray(intArrayOf(), 7))
    }
}
