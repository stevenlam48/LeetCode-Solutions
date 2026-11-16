package waterbottles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaterBottlesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(13, solution.numWaterBottles(9, 3))
    }

    @Test
    fun example2() {
        assertEquals(19, solution.numWaterBottles(15, 4))
    }

    @Test
    fun exchangeEveryBottle() {
        assertEquals(6, solution.numWaterBottles(5, 5))
    }

    @Test
    fun notEnoughBottlesToExchange() {
        assertEquals(2, solution.numWaterBottles(2, 3))
        assertEquals(1, solution.numWaterBottles(1, 2))
    }

    @Test
    fun smallExchangeCost() {
        assertEquals(199, solution.numWaterBottles(100, 2))
    }
}
