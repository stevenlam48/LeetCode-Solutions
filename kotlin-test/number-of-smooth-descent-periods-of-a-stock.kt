package numberofsmoothdescentperiodsofastock

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfSmoothDescentPeriodsOfAStockTest {
    @Test
    fun testExample1() {
        assertEquals(7L, Solution().getDescentPeriods(intArrayOf(3, 2, 1, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(4L, Solution().getDescentPeriods(intArrayOf(8, 6, 7, 7)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, Solution().getDescentPeriods(intArrayOf(1)))
    }

    @Test
    fun testFullDescent() {
        assertEquals(6L, Solution().getDescentPeriods(intArrayOf(3, 2, 1)))
    }

    @Test
    fun testNoDescent() {
        assertEquals(3L, Solution().getDescentPeriods(intArrayOf(1, 2, 3)))
    }
}
