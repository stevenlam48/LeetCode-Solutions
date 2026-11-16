package medianoftwosortedarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {
    @Test
    fun oddCombinedLength() {
        assertEquals(2.0, Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)), 0.0)
    }

    @Test
    fun evenCombinedLength() {
        assertEquals(2.5, Solution().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 0.0)
    }

    @Test
    fun oneArrayIsEmpty() {
        assertEquals(7.0, Solution().findMedianSortedArrays(intArrayOf(), intArrayOf(3, 7, 9)), 0.0)
        assertEquals(2.5, Solution().findMedianSortedArrays(intArrayOf(1, 4), intArrayOf()), 0.0)
    }

    @Test
    fun duplicatesAndNegatives() {
        assertEquals(-3.0, Solution().findMedianSortedArrays(intArrayOf(-5, -3, -1), intArrayOf(-4, -2)), 0.0)
        assertEquals(1.0, Solution().findMedianSortedArrays(intArrayOf(1, 1), intArrayOf(1, 2, 2)), 0.0)
    }

    @Test
    fun averageDoesNotOverflowInt() {
        assertEquals(
            Int.MAX_VALUE.toDouble(),
            Solution().findMedianSortedArrays(intArrayOf(Int.MAX_VALUE), intArrayOf(Int.MAX_VALUE)),
            0.0
        )
    }
}
