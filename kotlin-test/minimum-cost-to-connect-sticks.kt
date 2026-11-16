package minimumcosttoconnectsticks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToConnectSticksTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(14, solution.connectSticks(intArrayOf(2, 4, 3)))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(30, solution.connectSticks(intArrayOf(1, 8, 3, 5)))
    }

    @Test
    fun oneStickNeedsNoConnection() {
        assertEquals(0, solution.connectSticks(intArrayOf(10)))
    }

    @Test
    fun duplicateLengths() {
        assertEquals(10, solution.connectSticks(intArrayOf(2, 2, 2)))
    }
}
