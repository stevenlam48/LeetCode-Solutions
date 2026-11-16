package findthenumberofwaystoplacepeopleii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheNumberOfWaysToPlacePeopleIiTest {
    private val solution = Solution()

    @Test
    fun collinearAscendingPointsHaveNoValidPair() {
        val points = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
        )
        assertEquals(0, solution.numberOfPairs(points))
    }

    @Test
    fun middlePointBlocksOnlyTheOuterPair() {
        val points = arrayOf(
            intArrayOf(6, 2),
            intArrayOf(4, 4),
            intArrayOf(2, 6),
        )
        assertEquals(2, solution.numberOfPairs(points))
    }

    @Test
    fun equalXAndEqualYBoundariesAreAllowed() {
        val points = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(1, 3),
            intArrayOf(1, 1),
        )
        assertEquals(2, solution.numberOfPairs(points))
    }

    @Test
    fun negativeCoordinatesFollowTheSameRule() {
        val points = arrayOf(
            intArrayOf(1, -1),
            intArrayOf(-1, 1),
            intArrayOf(-3, 3),
        )
        assertEquals(2, solution.numberOfPairs(points))
    }

    @Test
    fun singlePointHasNoPair() {
        assertEquals(0, solution.numberOfPairs(arrayOf(intArrayOf(4, 7))))
    }
}
