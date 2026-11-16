package minimumcosttosplitintoonesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToSplitIntoOnesIiTest {
    @Test
    fun n1() {
        assertEquals(0L, Solution().minCost(1))
    }

    @Test
    fun n2() {
        assertEquals(1L, Solution().minCost(2))
    }

    @Test
    fun n3() {
        assertEquals(3L, Solution().minCost(3))
    }

    @Test
    fun large() {
        assertEquals(499999999500000000L, Solution().minCost(1000000000))
    }
}
