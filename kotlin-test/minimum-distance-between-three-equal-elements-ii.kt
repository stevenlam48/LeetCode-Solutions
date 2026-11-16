package minimumdistancebetweenthreeequalelementsii
// Time:  O(n)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceBetweenThreeEqualElementsIiTest {
    private val solution = Solution()

    @Test
    fun repeatedValueAtThreePositions() {
        assertEquals(8, solution.minimumDistance(intArrayOf(1, 2, 1, 2, 1)))
        assertEquals(4, solution.minimumDistance(intArrayOf(3, 3, 3)))
    }

    @Test
    fun noValueAppearsThreeTimes() {
        assertEquals(-1, solution.minimumDistance(intArrayOf(4, 4)))
        assertEquals(-1, solution.minimumDistance(intArrayOf()))
    }

    @Test
    fun compareDifferentValuesAndLaterWindows() {
        assertEquals(6, solution.minimumDistance(intArrayOf(1, 0, 1, 1)))
        assertEquals(4, solution.minimumDistance(intArrayOf(5, 0, 5, 5, 5)))
        assertEquals(-1, solution.minimumDistance(intArrayOf(1, 1, 2, 2)))
    }
}
