package findthenumberofwaystoplacepeoplei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfWaysToPlacePeopleITest {
    @Test
    fun ascendingDiagonalHasNoValidPairs() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(0, Solution().numberOfPairs(points))
    }

    @Test
    fun pointBlockingOneRectangleLeavesTwoPairs() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0))
        assertEquals(2, Solution().numberOfPairs(points))
    }

    @Test
    fun descendingDiagonalAllowsOnlyAdjacentPairs() {
        val points = arrayOf(intArrayOf(0, 2), intArrayOf(1, 1), intArrayOf(2, 0))
        assertEquals(2, Solution().numberOfPairs(points))
    }

    @Test
    fun sharedCoordinatesAllowBoundaryOnlyPairs() {
        val points = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )
        assertEquals(4, Solution().numberOfPairs(points))
    }
}
