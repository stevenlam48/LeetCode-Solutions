package limitoccurrencesinsortedarray
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LimitOccurrencesInSortedArrayTest {
    @Test
    fun limitsEachValueToKOccurrences() {
        assertArrayEquals(
            intArrayOf(1, 1, 2, 2, 3),
            Solution().limitOccurrences(intArrayOf(1, 1, 1, 2, 2, 3), 2)
        )
    }

    @Test
    fun removesAllDuplicatesWhenKIsOne() {
        assertArrayEquals(
            intArrayOf(-1, 0, 2),
            Solution().limitOccurrences(intArrayOf(-1, -1, 0, 0, 0, 2, 2), 1)
        )
    }

    @Test
    fun retainsUpToKOccurrences() {
        assertArrayEquals(
            intArrayOf(4, 4, 4),
            Solution().limitOccurrences(intArrayOf(4, 4, 4, 4, 4), 3)
        )
    }

    @Test
    fun handlesEmptyArray() {
        assertArrayEquals(IntArray(0), Solution().limitOccurrences(IntArray(0), 2))
    }
}
