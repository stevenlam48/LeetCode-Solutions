package maximumprofitfromvalidtopologicalorderindag

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProfitFromValidTopologicalOrderInDagTest {
    @Test
    fun chain() {
        assertEquals(
            14,
            Solution().maxProfit(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun singleEdge() {
        assertEquals(8, Solution().maxProfit(2, arrayOf(intArrayOf(0, 1)), intArrayOf(2, 3)))
    }

    @Test
    fun singleNode() {
        assertEquals(5, Solution().maxProfit(1, emptyArray(), intArrayOf(5)))
    }

    @Test
    fun cycle() {
        assertEquals(
            -1,
            Solution().maxProfit(2, arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)), intArrayOf(1, 1))
        )
    }

    @Test
    fun noEdges() {
        assertEquals(14, Solution().maxProfit(3, emptyArray(), intArrayOf(3, 2, 1)))
    }
}
