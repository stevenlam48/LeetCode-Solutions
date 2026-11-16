package numberofwaystoreconstructatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToReconstructATreeTest {
    @Test
    fun chainHasOneConstruction() {
        assertEquals(1, Solution().checkWays(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))))
    }

    @Test
    fun triangleHasTwoConstructions() {
        assertEquals(2, Solution().checkWays(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3))))
    }

    @Test
    fun incompatibleAncestors() {
        assertEquals(0, Solution().checkWays(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(1, 5))))
    }

    @Test
    fun disconnectedPairs() {
        assertEquals(0, Solution().checkWays(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }
}
