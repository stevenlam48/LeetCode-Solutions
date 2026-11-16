package minimumindexsumofcommonelements

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumIndexSumOfCommonElementsTest {
    @Test
    fun multipleCommonElementsCanTie() {
        assertEquals(3, Solution().minimumSum(intArrayOf(1, 2, 3), intArrayOf(4, 3, 2)))
    }

    @Test
    fun smallestIndexSumWins() {
        assertEquals(1, Solution().minimumSum(intArrayOf(1, 2, 3), intArrayOf(2, 4, 1)))
    }

    @Test
    fun noCommonElementsReturnsMinusOne() {
        assertEquals(-1, Solution().minimumSum(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun duplicateInFirstArrayUsesItsEarliestIndex() {
        assertEquals(2, Solution().minimumSum(intArrayOf(7, 8, 7), intArrayOf(9, 9, 7)))
    }
}
