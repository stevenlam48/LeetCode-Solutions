package validsubarrayswithmatchingsumdigitsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidSubarraysWithMatchingSumDigitsITest {
    @Test
    fun allOnes() {
        assertEquals(4, Solution().countValidSubarrays(intArrayOf(1, 1, 1, 1), 1))
    }

    @Test
    fun multiDigitSums() {
        assertEquals(3, Solution().countValidSubarrays(intArrayOf(1, 9, 1), 1))
        assertEquals(2, Solution().countValidSubarrays(intArrayOf(1, 11, 2, 22), 1))
    }

    @Test
    fun repeatedDigitSums() {
        assertEquals(3, Solution().countValidSubarrays(intArrayOf(2, 22, 222), 2))
        assertEquals(3, Solution().countValidSubarrays(intArrayOf(5, 55, 5), 5))
    }

    @Test
    fun noMatchingSums() {
        assertEquals(0, Solution().countValidSubarrays(intArrayOf(3, 13, 30), 1))
        assertEquals(0, Solution().countValidSubarrays(intArrayOf(9, 9, 9), 1))
    }

    @Test
    fun singleMatchingPrefix() {
        assertEquals(1, Solution().countValidSubarrays(intArrayOf(1, 2, 3, 4, 5), 1))
    }
}
