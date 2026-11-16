package minimumtotalcosttoprocessallelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTotalCostToProcessAllElementsTest {
    @Test
    fun multipleBatches() {
        assertEquals(3, Solution().minimumCost(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun exactSingleBatch() {
        assertEquals(0, Solution().minimumCost(intArrayOf(5), 5))
    }

    @Test
    fun unitCapacity() {
        assertEquals(3, Solution().minimumCost(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun largeValues() {
        assertEquals(1, Solution().minimumCost(intArrayOf(2_000_000_000, 2_000_000_000), 2_000_000_000))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().minimumCost(intArrayOf(), 3))
    }
}
