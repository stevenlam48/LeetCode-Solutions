package sumofperfectsquareancestors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfPerfectSquareAncestorsTest {
    private val solution = Solution()

    @Test
    fun matchingSquarefreePartsOnSeparateBranches() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))
        assertEquals(2L, solution.sumOfAncestors(4, edges, intArrayOf(2, 3, 3, 2)))
    }

    @Test
    fun singleNodeHasNoAncestorPair() {
        assertEquals(0L, solution.sumOfAncestors(1, emptyArray(), intArrayOf(36)))
    }

    @Test
    fun perfectSquareValuesShareUnitSquarefreePart() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3))
        assertEquals(4L, solution.sumOfAncestors(4, edges, intArrayOf(4, 9, 4, 36)))
    }

    @Test
    fun multipleMatchingAncestors() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(3L, solution.sumOfAncestors(4, edges, intArrayOf(2, 8, 18, 3)))
    }
}
