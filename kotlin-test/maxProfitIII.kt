package maxProfitIII

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxProfitIIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testDecreasing() {
        assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.maxProfit(intArrayOf(1)))
    }
}
