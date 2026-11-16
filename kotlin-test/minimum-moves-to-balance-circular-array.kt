package minimummovestobalancecirculararray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToBalanceCircularArrayTest {

    private val solution = Solution()

    @Test
    fun testAlreadyBalanced() {
        assertEquals(0L, solution.minMoves(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testSingleDeficitCoveredByNeighbor() {
        assertEquals(4L, solution.minMoves(intArrayOf(5, 1, -4)))
    }

    @Test
    fun testDeficitCoveredBothNeighbors() {
        assertEquals(1L, solution.minMoves(intArrayOf(-1, -1, 2)))
    }

    @Test
    fun testNegativeTotal() {
        assertEquals(-1L, solution.minMoves(intArrayOf(1, -2)))
    }

    @Test
    fun testSinglePositive() {
        assertEquals(0L, solution.minMoves(intArrayOf(5)))
    }

    @Test
    fun testDeficitNeedsTwoFromOneSide() {
        assertEquals(2L, solution.minMoves(intArrayOf(-2, 1, 1)))
    }
}
