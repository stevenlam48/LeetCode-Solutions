package maximumscoreafterapplyingoperationsonatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreAfterApplyingOperationsOnATreeTest {
    private val solution = Solution()

    @Test
    fun balancesRootAndSubtreeCosts() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(2, 4),
            intArrayOf(4, 5)
        )

        assertEquals(
            11L,
            solution.maximumScoreAfterOperations(edges, intArrayOf(5, 2, 5, 2, 1, 1))
        )
    }

    @Test
    fun twoNodeTreeKeepsLargerValue() {
        val edges = arrayOf(intArrayOf(0, 1))

        assertEquals(2L, solution.maximumScoreAfterOperations(edges, intArrayOf(1, 2)))
    }

    @Test
    fun singleNodeMustBecomeUnhealthy() {
        assertEquals(0L, solution.maximumScoreAfterOperations(emptyArray(), intArrayOf(7)))
    }

    @Test
    fun zeroValuedInternalNodeRequiresNoOperation() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))

        assertEquals(5L, solution.maximumScoreAfterOperations(edges, intArrayOf(0, 2, 3)))
    }

    @Test
    fun starCanKeepEveryLeafHealthy() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))

        assertEquals(10L, solution.maximumScoreAfterOperations(edges, intArrayOf(4, 2, 3, 5)))
    }
}
