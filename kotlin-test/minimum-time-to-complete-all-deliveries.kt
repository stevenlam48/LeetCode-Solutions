package minimumtimetocompletealldeliveries

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeToCompleteAllDeliveriesTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(2L, solution.minimumTime(intArrayOf(1, 1), intArrayOf(2, 3)))
    }

    @Test
    fun testMoreDeliveries() {
        assertEquals(10L, solution.minimumTime(intArrayOf(5, 3), intArrayOf(2, 4)))
        assertEquals(4L, solution.minimumTime(intArrayOf(2, 2), intArrayOf(2, 3)))
    }

    @Test
    fun testAsymmetricLoad() {
        assertEquals(7L, solution.minimumTime(intArrayOf(1, 5), intArrayOf(2, 3)))
        assertEquals(11L, solution.minimumTime(intArrayOf(4, 7), intArrayOf(3, 5)))
    }

    @Test
    fun testEqualPeriods() {
        assertEquals(2L, solution.minimumTime(intArrayOf(1, 1), intArrayOf(3, 5)))
    }
}
