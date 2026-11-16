package coinchange2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CoinChange2Test {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.change(5, intArrayOf(1, 2, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.change(3, intArrayOf(2)))
    }

    @Test
    fun testExample3() {
        assertEquals(1, solution.change(10, intArrayOf(10)))
    }

    @Test
    fun testZeroAmount() {
        assertEquals(1, solution.change(0, intArrayOf(1, 2)))
    }

    @Test
    fun testUnreachableAmount() {
        assertEquals(0, solution.change(7, intArrayOf(2, 4)))
    }
}
