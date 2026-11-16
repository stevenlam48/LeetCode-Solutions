package twofurthesthouseswithdifferentcolors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoFurthestHousesWithDifferentColorsTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxDistance(intArrayOf(1, 1, 1, 6, 1, 1, 1)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxDistance(intArrayOf(1, 8, 3, 8, 3)))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().maxDistance(intArrayOf(0, 1)))
    }

    @Test
    fun allSameColor() {
        assertEquals(0, Solution().maxDistance(intArrayOf(4, 4, 4)))
    }
}
