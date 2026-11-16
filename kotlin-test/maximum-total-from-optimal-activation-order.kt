package maximumtotalfromoptimalactivationorder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalFromOptimalActivationOrderTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(10L, solution.maxTotal(intArrayOf(3, 2, 5), intArrayOf(2, 2, 1)))
    }

    @Test
    fun singleSlotPerLimit() {
        assertEquals(4L, solution.maxTotal(intArrayOf(1, 2, 3, 4), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun allCanBeActivated() {
        assertEquals(6L, solution.maxTotal(intArrayOf(1, 2, 3), intArrayOf(3, 3, 3)))
    }

    @Test
    fun zeroLimit() {
        assertEquals(0L, solution.maxTotal(intArrayOf(5), intArrayOf(0)))
    }
}
