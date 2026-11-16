package minimummovestobalancecirculararrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumMovesToBalanceCircularArrayIiTest {

    private val solution = Solution()

    @Test
    fun testAlreadyBalanced() {
        assertEquals(0L, solution.minMoves(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testSimpleTransfer() {
        assertEquals(1L, solution.minMoves(intArrayOf(1, -1)))
    }

    @Test
    fun testTwoUnitDeficit() {
        assertEquals(2L, solution.minMoves(intArrayOf(1, 1, -2)))
    }

    @Test
    fun testAlternating() {
        assertEquals(2L, solution.minMoves(intArrayOf(-1, 1, -1, 1)))
    }

    @Test
    fun testNegativeTotal() {
        assertEquals(-1L, solution.minMoves(intArrayOf(1, -2)))
    }

    @Test
    fun testSinglePositive() {
        assertEquals(0L, solution.minMoves(intArrayOf(5)))
    }
}
