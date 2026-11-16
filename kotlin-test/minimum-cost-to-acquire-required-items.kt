package minimumcosttoacquirerequireditems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToAcquireRequiredItemsTest {
    @Test
    fun standardExamples() {
        assertEquals(5L, Solution().minimumCost(3, 2, 1, 3, 5))
        assertEquals(22L, Solution().minimumCost(5, 4, 9, 2, 3))
    }

    @Test
    fun onlySecondItemNeeded() {
        assertEquals(10L, Solution().minimumCost(1, 2, 3, 0, 5))
    }

    @Test
    fun nothingNeeded() {
        assertEquals(0L, Solution().minimumCost(1, 1, 1, 0, 0))
    }

    @Test
    fun largeValuesDoNotOverflow() {
        assertEquals(
            1_000_000_000_000_000_000L,
            Solution().minimumCost(1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000, 1_000_000_000)
        )
    }
}
