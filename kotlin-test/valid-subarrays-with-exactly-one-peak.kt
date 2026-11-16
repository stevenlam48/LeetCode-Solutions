package validsubarrayswithexactlyonepeak

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidSubarraysWithExactlyOnePeakTest {
    @Test
    fun singlePeak() {
        assertEquals(4L, Solution().validSubarrays(intArrayOf(1, 3, 2), 1))
        assertEquals(4L, Solution().validSubarrays(intArrayOf(1, 3, 2), 2))
        assertEquals(4L, Solution().validSubarrays(intArrayOf(3, 5, 4), 1))
    }

    @Test
    fun peakDistanceIsCappedByK() {
        assertEquals(4L, Solution().validSubarrays(intArrayOf(3, 2, 3, 2, 3), 1))
        assertEquals(9L, Solution().validSubarrays(intArrayOf(3, 2, 3, 2, 3), 2))
    }

    @Test
    fun twoPeaksAreCountedSeparately() {
        assertEquals(8L, Solution().validSubarrays(intArrayOf(1, 3, 2, 1, 3, 2), 1))
        assertEquals(12L, Solution().validSubarrays(intArrayOf(1, 3, 2, 1, 3, 2), 2))
        assertEquals(8L, Solution().validSubarrays(intArrayOf(1, 2, 1, 2, 1), 1))
    }

    @Test
    fun noPeakMeansNoValidSubarray() {
        assertEquals(0L, Solution().validSubarrays(intArrayOf(1, 2, 3), 5))
        assertEquals(0L, Solution().validSubarrays(intArrayOf(1), 5))
        assertEquals(0L, Solution().validSubarrays(intArrayOf(1, 2), 5))
    }

    @Test
    fun negativeValues() {
        assertEquals(0L, Solution().validSubarrays(intArrayOf(-1, -2, -3), 5))
        assertEquals(4L, Solution().validSubarrays(intArrayOf(-3, -1, -2), 1))
    }
}
