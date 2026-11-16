package selldiminishingvaluedcoloredballs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SellDiminishingValuedColoredBallsTest {
    @Test
    fun exampleTwoAndFive() {
        assertEquals(14, Solution().maxProfit(intArrayOf(2, 5), 4))
    }

    @Test
    fun exampleThreeAndFive() {
        assertEquals(19, Solution().maxProfit(intArrayOf(3, 5), 6))
    }

    @Test
    fun exampleMixedInventory() {
        assertEquals(110, Solution().maxProfit(intArrayOf(2, 8, 4, 10, 6), 20))
    }

    @Test
    fun singleBall() {
        assertEquals(1, Solution().maxProfit(intArrayOf(1), 1))
    }

    @Test
    fun sellWholePile() {
        assertEquals(3, Solution().maxProfit(intArrayOf(2), 2))
    }
}
