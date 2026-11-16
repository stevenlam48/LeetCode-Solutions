package houserobberv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HouseRobberVTest {
    @Test
    fun equalColorsForbidAdjacentHouses() {
        assertEquals(8L, Solution().rob(intArrayOf(1, 2, 7, 4), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun differentColorsAllowAllHouses() {
        assertEquals(14L, Solution().rob(intArrayOf(1, 2, 7, 4), intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun mixedColors() {
        assertEquals(9L, Solution().rob(intArrayOf(1, 4, 3, 5), intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun combinesAdjacentAndSeparatedChoices() {
        assertEquals(16L, Solution().rob(intArrayOf(5, 1, 1, 10), intArrayOf(1, 2, 2, 1)))
    }

    @Test
    fun singleHouse() {
        assertEquals(42L, Solution().rob(intArrayOf(42), intArrayOf(9)))
    }

    @Test
    fun sumUsesLong() {
        assertEquals(
            2L * Int.MAX_VALUE,
            Solution().rob(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE), intArrayOf(0, 1))
        )
    }
}
