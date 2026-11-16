package searchinasortedarrayofunknownsize

// Time:  O(logn)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchInASortedArrayOfUnknownSizeTest {
    @Test
    fun findsExistingValue() {
        val reader = ArrayReader(intArrayOf(-1, 0, 3, 5, 9, 12))
        assertEquals(4, Solution().search(reader, 9))
    }

    @Test
    fun rejectsMissingValue() {
        val reader = ArrayReader(intArrayOf(-1, 0, 3, 5, 9, 12))
        assertEquals(-1, Solution().search(reader, 2))
    }

    @Test
    fun emptyReader() {
        assertEquals(-1, Solution().search(ArrayReader(intArrayOf()), 1))
    }

    @Test
    fun outOfBoundsUsesSentinel() {
        assertEquals(Int.MAX_VALUE, ArrayReader(intArrayOf(1)).get(1))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().search(ArrayReader(intArrayOf(7)), 7))
        assertEquals(-1, Solution().search(ArrayReader(intArrayOf(7)), 8))
    }
}
