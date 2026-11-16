package checkknighttourconfiguration

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckKnightTourConfigurationTest {
    private val solution = Solution()

    @Test
    fun testValidTour() {
        val grid = arrayOf(
            intArrayOf(0, 11, 24, 17, 2),
            intArrayOf(21, 16, 1, 12, 23),
            intArrayOf(10, 7, 22, 3, 18),
            intArrayOf(15, 20, 5, 8, 13),
            intArrayOf(6, 9, 14, 19, 4)
        )
        assertTrue(solution.checkValidGrid(grid))
    }

    @Test
    fun testDoesNotStartAtZero() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 0)
        )
        assertFalse(solution.checkValidGrid(grid))
    }

    @Test
    fun testInvalidThreeByThree() {
        val grid = arrayOf(
            intArrayOf(0, 3, 6),
            intArrayOf(5, 1, 8),
            intArrayOf(2, 7, 4)
        )
        assertFalse(solution.checkValidGrid(grid))
    }

    @Test
    fun testSingleCell() {
        assertTrue(solution.checkValidGrid(arrayOf(intArrayOf(0))))
    }
}
