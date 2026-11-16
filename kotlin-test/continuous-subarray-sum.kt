package continuoussubarraysum

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContinuousSubarraySumTest {
    @Test
    fun interiorSubarrayIsMultipleOfK() {
        assertTrue(Solution().checkSubarraySum(intArrayOf(23, 2, 4, 6, 7), 6))
    }

    @Test
    fun longerSubarrayIsMultipleOfK() {
        assertTrue(Solution().checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 6))
    }

    @Test
    fun noQualifyingSubarrayIsMultipleOfThirteen() {
        assertFalse(Solution().checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 13))
    }

    @Test
    fun zeroModulusUsesRawPrefixSums() {
        assertTrue(Solution().checkSubarraySum(intArrayOf(0, 0), 0))
        assertFalse(Solution().checkSubarraySum(intArrayOf(0, 1, 0), 0))
    }
}
