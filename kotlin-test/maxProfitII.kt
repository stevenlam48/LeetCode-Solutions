package maxProfitII

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxProfitIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(7, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
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
    fun testEmpty() {
        assertEquals(0, solution.maxProfit(intArrayOf()))
    }
}
