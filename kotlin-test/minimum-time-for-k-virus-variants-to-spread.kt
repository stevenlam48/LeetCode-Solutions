package minimumtimeforkvirusvariantstospread

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeForKVirusVariantsToSpreadTest {
    private val solution = Solution()

    @Test
    fun testTwoPoints() {
        assertEquals(1, solution.minDayskVariants(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2)), 2))
        assertEquals(0, solution.minDayskVariants(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2)), 1))
    }

    @Test
    fun testThreePointsDiagonal() {
        assertEquals(2, solution.minDayskVariants(arrayOf(
            intArrayOf(1, 1), intArrayOf(3, 3), intArrayOf(5, 5)
        ), 2))
    }

    @Test
    fun testThreePointsTriangle() {
        assertEquals(4, solution.minDayskVariants(arrayOf(
            intArrayOf(0, 0), intArrayOf(0, 4), intArrayOf(4, 0)
        ), 3))
    }

    @Test
    fun testCollinearPoints() {
        assertEquals(1, solution.minDayskVariants(arrayOf(
            intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 0)
        ), 2))
    }

    @Test
    fun testDuplicatePoints() {
        assertEquals(0, solution.minDayskVariants(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)), 2))
    }

    @Test
    fun testFarApart() {
        assertEquals(10, solution.minDayskVariants(arrayOf(intArrayOf(0, 0), intArrayOf(10, 10)), 2))
    }
}
