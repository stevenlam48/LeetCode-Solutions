package inversecoinchange

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InverseCoinChangeTest {
    private val solution = Solution()

    @Test
    fun testTwoCoins() {
        assertArrayEquals(
            intArrayOf(2, 3),
            solution.findCoins(intArrayOf(0, 1, 1, 1, 1, 2, 1))
        )
    }

    @Test
    fun testSingleCoin() {
        assertArrayEquals(intArrayOf(3), solution.findCoins(intArrayOf(0, 0, 1, 0, 0, 1)))
    }

    @Test
    fun testCoinOne() {
        assertArrayEquals(intArrayOf(1), solution.findCoins(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testInvalidWays() {
        assertArrayEquals(intArrayOf(), solution.findCoins(intArrayOf(0, 2, 1)))
    }

    @Test
    fun testEmpty() {
        assertArrayEquals(intArrayOf(), solution.findCoins(intArrayOf()))
    }
}
