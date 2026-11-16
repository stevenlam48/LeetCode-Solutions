package lengthoflongestsubarraywithatmostkfrequency

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LengthOfLongestSubarrayWithAtMostKFrequencyTest {
    @Test
    fun findsLengthSixInFirstExample() {
        assertEquals(6, Solution().maxSubarrayLength(intArrayOf(1, 2, 3, 1, 2, 3, 1, 2), 2))
    }

    @Test
    fun findsLengthTwoInSecondExample() {
        assertEquals(2, Solution().maxSubarrayLength(intArrayOf(1, 2, 1, 2, 1, 2, 1, 2), 1))
    }

    @Test
    fun findsLengthTwoInThirdExample() {
        assertEquals(2, Solution().maxSubarrayLength(intArrayOf(1, 4, 4, 3), 1))
    }

    @Test
    fun capsRepeatedValueAtFrequencyLimit() {
        assertEquals(3, Solution().maxSubarrayLength(intArrayOf(5, 5, 5, 5, 5), 3))
    }

    @Test
    fun handlesNegativeValues() {
        assertEquals(2, Solution().maxSubarrayLength(intArrayOf(-1, -1, 0), 1))
    }

    @Test
    fun returnsZeroForEmptyInputOrZeroFrequencyLimit() {
        assertEquals(0, Solution().maxSubarrayLength(intArrayOf(), 2))
        assertEquals(0, Solution().maxSubarrayLength(intArrayOf(1, 2), 0))
    }
}
