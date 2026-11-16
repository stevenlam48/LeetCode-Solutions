package minimumcostforcuttingcakei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostForCuttingCakeITest {
    @Test
    fun standardExamples() {
        assertEquals(13, Solution().minimumCost(3, 2, intArrayOf(1, 3), intArrayOf(5)))
        assertEquals(15, Solution().minimumCost(2, 2, intArrayOf(7), intArrayOf(4)))
    }

    @Test
    fun singleDirection() {
        assertEquals(3, Solution().minimumCost(1, 2, intArrayOf(), intArrayOf(3)))
        assertEquals(3, Solution().minimumCost(2, 1, intArrayOf(3), intArrayOf()))
    }

    @Test
    fun noCutsNeeded() {
        assertEquals(0, Solution().minimumCost(1, 1, intArrayOf(), intArrayOf()))
    }

    @Test
    fun equalCutCosts() {
        assertEquals(30, Solution().minimumCost(2, 2, intArrayOf(10), intArrayOf(10)))
    }
}
