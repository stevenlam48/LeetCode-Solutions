package maximumenergyboostfromtwodrinks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEnergyBoostFromTwoDrinksTest {
    @Test
    fun example1() {
        assertEquals(5L, Solution().maxEnergyBoost(intArrayOf(1, 3, 1), intArrayOf(3, 1, 1)))
    }

    @Test
    fun example2() {
        assertEquals(7L, Solution().maxEnergyBoost(intArrayOf(4, 1, 1), intArrayOf(1, 1, 3)))
    }

    @Test
    fun allFromOneDrink() {
        assertEquals(15L, Solution().maxEnergyBoost(intArrayOf(5, 5, 5), intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleHour() {
        assertEquals(7L, Solution().maxEnergyBoost(intArrayOf(7), intArrayOf(3)))
    }

    @Test
    fun largeValues() {
        assertEquals(
            300000L,
            Solution().maxEnergyBoost(
                intArrayOf(100000, 100000, 100000),
                intArrayOf(100000, 100000, 100000)
            )
        )
    }
}
