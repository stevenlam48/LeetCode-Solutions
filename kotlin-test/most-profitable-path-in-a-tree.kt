package mostprofitablepathinatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostProfitablePathInATreeTest {
    private val solution = Solution()

    @Test
    fun choosesMostProfitableLeafPath() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4))
        assertEquals(8, solution.mostProfitablePath(edges, 3, intArrayOf(3, 2, 1, 10, 4)))
    }

    @Test
    fun splitsAmountForSingleNodeWhenBobStartsAtRoot() {
        assertEquals(5, solution.mostProfitablePath(emptyArray(), 0, intArrayOf(10)))
    }

    @Test
    fun splitsGateWhenAliceAndBobArriveTogether() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(7, solution.mostProfitablePath(edges, 2, intArrayOf(4, 6, 8)))
    }

    @Test
    fun skipsGatesBobReachesFirst() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(12, solution.mostProfitablePath(edges, 1, intArrayOf(4, 6, 8)))
    }
}
