package longestcontinuoussubarraywithabsolutedifflessthanorequaltolimit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimitTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2, solution.longestSubarray(intArrayOf(8, 2, 4, 7), 4))
    }

    @Test
    fun longerWindow() {
        assertEquals(4, solution.longestSubarray(intArrayOf(10, 1, 2, 4, 7, 2), 5))
    }

    @Test
    fun equalValues() {
        assertEquals(4, solution.longestSubarray(intArrayOf(4, 4, 4, 4), 0))
    }

    @Test
    fun singleValidElement() {
        assertEquals(1, solution.longestSubarray(intArrayOf(1, 5, 10), 2))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.longestSubarray(intArrayOf(), 3))
    }
}
