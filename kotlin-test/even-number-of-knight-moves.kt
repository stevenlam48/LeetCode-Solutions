package evennumberofknightmoves

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvenNumberOfKnightMovesTest {
    private val solution = Solution()

    @Test
    fun testSameSquare() {
        assertTrue(solution.canReach(intArrayOf(0, 0), intArrayOf(0, 0)))
        assertTrue(solution.canReach(intArrayOf(3, 4), intArrayOf(3, 4)))
    }

    @Test
    fun testSameParity() {
        assertTrue(solution.canReach(intArrayOf(0, 0), intArrayOf(1, 1)))
        assertTrue(solution.canReach(intArrayOf(0, 0), intArrayOf(2, 2)))
    }

    @Test
    fun testDifferentParity() {
        assertFalse(solution.canReach(intArrayOf(0, 0), intArrayOf(1, 0)))
        assertFalse(solution.canReach(intArrayOf(0, 0), intArrayOf(2, 1)))
    }

    @Test
    fun testNegativeCoordinates() {
        assertTrue(solution.canReach(intArrayOf(-1, -1), intArrayOf(1, 1)))
        assertTrue(solution.canReach(intArrayOf(-1, -1), intArrayOf(0, 0)))
        assertFalse(solution.canReach(intArrayOf(-1, -1), intArrayOf(0, 1)))
    }
}
