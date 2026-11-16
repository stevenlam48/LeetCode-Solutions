package coinchange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CoinChangeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.coinChange(intArrayOf(1, 2, 5), 11))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, solution.coinChange(intArrayOf(2), 3))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.coinChange(intArrayOf(1), 0))
    }

    @Test
    fun testSingleCoin() {
        assertEquals(2, solution.coinChange(intArrayOf(1), 2))
    }

    @Test
    fun testLargeAmount() {
        assertEquals(20, solution.coinChange(intArrayOf(186, 419, 83, 408), 6249))
    }
}
