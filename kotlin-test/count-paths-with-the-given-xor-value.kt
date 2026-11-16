package countpathswiththegivenxorvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPathsWithTheGivenXorValueTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val grid = arrayOf(
            intArrayOf(2, 1, 5),
            intArrayOf(7, 10, 0),
            intArrayOf(12, 6, 4)
        )
        assertEquals(3, solution.countPathsWithXorValue(grid, 11))
    }

    @Test
    fun multiplePathsWithSameXor() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(2, solution.countPathsWithXorValue(grid, 0))
    }

    @Test
    fun singleCell() {
        assertEquals(1, solution.countPathsWithXorValue(arrayOf(intArrayOf(7)), 7))
        assertEquals(0, solution.countPathsWithXorValue(arrayOf(intArrayOf(7)), 6))
    }
}
