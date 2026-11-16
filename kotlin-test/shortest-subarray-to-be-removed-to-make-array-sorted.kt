package shortestsubarraytoberemovedtomakearraysorted

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestSubarrayToBeRemovedToMakeArraySortedTest {
    @Test
    fun removesMiddleUnsortedPart() {
        assertEquals(3, Solution().findLengthOfShortestSubarray(intArrayOf(1, 2, 3, 10, 4, 2, 3, 5)))
    }

    @Test
    fun removesEverythingExceptOneElement() {
        assertEquals(4, Solution().findLengthOfShortestSubarray(intArrayOf(5, 4, 3, 2, 1)))
        assertEquals(1, Solution().findLengthOfShortestSubarray(intArrayOf(2, 1)))
    }

    @Test
    fun alreadySortedNeedsNoRemoval() {
        assertEquals(0, Solution().findLengthOfShortestSubarray(intArrayOf(1, 2, 3)))
        assertEquals(0, Solution().findLengthOfShortestSubarray(intArrayOf(1)))
    }

    @Test
    fun removesSingleOutOfPlaceElement() {
        assertEquals(1, Solution().findLengthOfShortestSubarray(intArrayOf(1, 3, 2, 2, 2)))
        assertEquals(1, Solution().findLengthOfShortestSubarray(intArrayOf(1, 3, 2, 4, 5)))
    }

    @Test
    fun handlesDuplicatesAtBoundaries() {
        assertEquals(1, Solution().findLengthOfShortestSubarray(intArrayOf(2, 2, 2, 1, 2, 2, 2)))
    }
}
