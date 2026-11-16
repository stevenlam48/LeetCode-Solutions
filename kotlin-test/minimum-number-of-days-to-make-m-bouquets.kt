package minimumnumberofdaystomakembouquets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfDaysToMakeMBouquetsTest {
    private val solution = Solution()

    @Test
    fun singleFlowerBouquets() {
        assertEquals(3, solution.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1))
    }

    @Test
    fun impossibleBouquets() {
        assertEquals(-1, solution.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2))
    }

    @Test
    fun waitsForMiddleFlower() {
        assertEquals(12, solution.minDays(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3))
    }

    @Test
    fun oneFlower() {
        assertEquals(4, solution.minDays(intArrayOf(4), 1, 1))
    }
}
