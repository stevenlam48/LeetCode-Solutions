package largestelementinanarrayaftermergeoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestElementInAnArrayAfterMergeOperationsTest {
    @Test
    fun exampleArray() {
        assertEquals(21L, Solution().maxArrayValue(intArrayOf(2, 3, 7, 9, 3)))
    }

    @Test
    fun mergeEntireArray() {
        assertEquals(11L, Solution().maxArrayValue(intArrayOf(5, 3, 3)))
    }

    @Test
    fun decreasingArrayCannotMerge() {
        assertEquals(9L, Solution().maxArrayValue(intArrayOf(9, 5, 2)))
    }

    @Test
    fun singleElementAndLargeSum() {
        assertEquals(7L, Solution().maxArrayValue(intArrayOf(7)))
        assertEquals(3_000_000_000L, Solution().maxArrayValue(intArrayOf(1_000_000_000, 1_000_000_000, 1_000_000_000)))
    }
}
