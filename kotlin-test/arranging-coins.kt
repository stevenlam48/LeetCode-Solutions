package arrangingcoins

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArrangingCoinsTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertEquals(2, solution.arrangeCoins(5))
    }

    @Test
    fun testExactTriangle() {
        assertEquals(3, solution.arrangeCoins(6))
    }

    @Test
    fun testOne() {
        assertEquals(1, solution.arrangeCoins(1))
    }

    @Test
    fun testLarge() {
        assertEquals(60070, solution.arrangeCoins(1804289383))
    }
}
