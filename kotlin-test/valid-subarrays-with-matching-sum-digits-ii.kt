package validsubarrayswithmatchingsumdigitsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidSubarraysWithMatchingSumDigitsIITest {
    @Test
    fun allOnes() {
        assertEquals(4L, Solution().countValidSubarrays(intArrayOf(1, 1, 1, 1), 1))
    }

    @Test
    fun repeatedDigitSums() {
        assertEquals(3L, Solution().countValidSubarrays(intArrayOf(2, 22, 222), 2))
        assertEquals(3L, Solution().countValidSubarrays(intArrayOf(5, 55, 5), 5))
        assertEquals(4L, Solution().countValidSubarrays(intArrayOf(2, 2, 2, 2), 2))
    }

    @Test
    fun noMatchingSums() {
        assertEquals(0L, Solution().countValidSubarrays(intArrayOf(3, 13, 30), 1))
    }

    @Test
    fun largeValuesUseLongPrefixSums() {
        assertEquals(2L, Solution().countValidSubarrays(intArrayOf(999999999, 999999999), 9))
    }

    @Test
    fun singleMatchingPrefix() {
        assertEquals(1L, Solution().countValidSubarrays(intArrayOf(1, 2, 3, 4, 5), 1))
    }
}
