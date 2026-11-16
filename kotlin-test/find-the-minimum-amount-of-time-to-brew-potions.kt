package findtheminimumamountoftimetobrewpotions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMinimumAmountOfTimeToBrewPotionsTest {
    @Test
    fun example1() {
        assertEquals(
            110L,
            Solution().minTime(intArrayOf(1, 5, 2, 4), intArrayOf(5, 1, 4, 2))
        )
    }

    @Test
    fun example2() {
        assertEquals(
            5L,
            Solution().minTime(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
        )
    }

    @Test
    fun example3() {
        assertEquals(
            22L,
            Solution().minTime(intArrayOf(1, 2, 3, 4), intArrayOf(1, 1, 1, 1))
        )
    }

    @Test
    fun singlePotion() {
        assertEquals(50L, Solution().minTime(intArrayOf(5), intArrayOf(10)))
    }
}
