package minimumtimetoeatallgrains

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToEatAllGrainsTest {
    @Test
    fun multipleHensAndGrains() {
        assertEquals(2, Solution().minimumTime(intArrayOf(3, 6, 7), intArrayOf(2, 4, 7, 9)))
    }

    @Test
    fun distantGrain() {
        assertEquals(2, Solution().minimumTime(intArrayOf(4, 6, 109), intArrayOf(4, 8, 109)))
    }

    @Test
    fun grainAtHen() {
        assertEquals(0, Solution().minimumTime(intArrayOf(5), intArrayOf(5)))
    }

    @Test
    fun negativeCoordinates() {
        assertEquals(1, Solution().minimumTime(intArrayOf(-5, 1), intArrayOf(-6, 0)))
    }
}
