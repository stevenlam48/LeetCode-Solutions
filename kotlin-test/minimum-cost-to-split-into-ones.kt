package minimumcosttosplitintoones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToSplitIntoOnesTest {
    @Test
    fun n1() {
        assertEquals(0, Solution().minCost(1))
    }

    @Test
    fun n2() {
        assertEquals(1, Solution().minCost(2))
    }

    @Test
    fun n3() {
        assertEquals(3, Solution().minCost(3))
    }

    @Test
    fun n4() {
        assertEquals(6, Solution().minCost(4))
    }

    @Test
    fun n5() {
        assertEquals(10, Solution().minCost(5))
    }
}
