package minimumcostforcuttingcakeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostForCuttingCakeIITest {
    @Test
    fun standardExamples() {
        assertEquals(13L, Solution().minimumCost(3, 2, intArrayOf(1, 3), intArrayOf(5)))
        assertEquals(15L, Solution().minimumCost(2, 2, intArrayOf(7), intArrayOf(4)))
    }

    @Test
    fun singleDirection() {
        assertEquals(3L, Solution().minimumCost(1, 2, intArrayOf(), intArrayOf(3)))
        assertEquals(3L, Solution().minimumCost(2, 1, intArrayOf(3), intArrayOf()))
    }

    @Test
    fun noCutsNeeded() {
        assertEquals(0L, Solution().minimumCost(1, 1, intArrayOf(), intArrayOf()))
    }

    @Test
    fun largeCostsDoNotOverflow() {
        assertEquals(300000L, Solution().minimumCost(2, 2, intArrayOf(100000), intArrayOf(100000)))
    }
}
