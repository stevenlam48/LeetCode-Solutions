package shortestunsortedcontinuoussubarray

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestUnsortedContinuousSubarrayTest {
    @Test
    fun findsUnsortedMiddle() {
        assertEquals(5, Solution().findUnsortedSubarray(intArrayOf(2, 6, 4, 8, 10, 9, 15)))
    }

    @Test
    fun alreadySortedReturnsZero() {
        assertEquals(0, Solution().findUnsortedSubarray(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, Solution().findUnsortedSubarray(intArrayOf(1)))
    }

    @Test
    fun singleAdjacentSwap() {
        assertEquals(2, Solution().findUnsortedSubarray(intArrayOf(1, 3, 2, 4, 5)))
        assertEquals(2, Solution().findUnsortedSubarray(intArrayOf(2, 1)))
    }

    @Test
    fun reverseSortedNeedsWholeArray() {
        assertEquals(4, Solution().findUnsortedSubarray(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun handlesDuplicates() {
        assertEquals(3, Solution().findUnsortedSubarray(intArrayOf(1, 2, 4, 5, 3)))
        assertEquals(0, Solution().findUnsortedSubarray(intArrayOf(2, 2, 2)))
    }
}
