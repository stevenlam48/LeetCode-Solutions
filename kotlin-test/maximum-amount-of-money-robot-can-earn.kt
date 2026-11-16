package maximumamountofmoneyrobotcanearn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAmountOfMoneyRobotCanEarnTest {
    private val solution = Solution()

    @Test
    fun twoNeutralizationsImproveMixedGrid() {
        val coins = arrayOf(
            intArrayOf(0, 1, -1),
            intArrayOf(1, -2, 3),
            intArrayOf(2, -3, 4)
        )
        assertEquals(8, solution.maximumAmount(coins))
    }

    @Test
    fun positiveGrid() {
        val coins = arrayOf(intArrayOf(10, 10, 10), intArrayOf(10, 10, 10))
        assertEquals(40, solution.maximumAmount(coins))
    }

    @Test
    fun singleNegativeCellCanBeNeutralized() {
        assertEquals(0, solution.maximumAmount(arrayOf(intArrayOf(-5))))
    }

    @Test
    fun tallGridUsesTransposedAccess() {
        val coins = arrayOf(intArrayOf(-1, 2), intArrayOf(3, -4), intArrayOf(5, 6))
        assertEquals(14, solution.maximumAmount(coins))
    }

    @Test
    fun singleColumn() {
        val coins = arrayOf(intArrayOf(-2), intArrayOf(-3), intArrayOf(4))
        assertEquals(4, solution.maximumAmount(coins))
    }
}
