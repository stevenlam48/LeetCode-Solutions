package splitarraylargestsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitArrayLargestSumTest {
    @Test
    fun firstLeetCodeExample() {
        assertEquals(18, Solution().splitArray(intArrayOf(7, 2, 5, 10, 8), 2))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(9, Solution().splitArray(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun oneSubarrayUsesTotalSum() {
        assertEquals(15, Solution().splitArray(intArrayOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun eachElementInOwnSubarrayUsesMaximum() {
        assertEquals(4, Solution().splitArray(intArrayOf(1, 4, 4), 3))
    }

    @Test
    fun singleElementArray() {
        assertEquals(10, Solution().splitArray(intArrayOf(10), 1))
    }
}
