package minimumdistancetothetargetelement
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDistanceToTheTargetElementTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(1, solution.getMinDistance(intArrayOf(1, 2, 3, 4, 5), 5, 3))
        assertEquals(0, solution.getMinDistance(intArrayOf(1), 1, 0))
        assertEquals(0, solution.getMinDistance(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 1, 0))
    }

    @Test
    fun equidistantTargets() {
        assertEquals(2, solution.getMinDistance(intArrayOf(4, 0, 5, 0, 4), 4, 2))
    }

    @Test
    fun targetOnlyOnOneSide() {
        assertEquals(3, solution.getMinDistance(intArrayOf(8, 2, 2, 3), 8, 3))
    }
}
