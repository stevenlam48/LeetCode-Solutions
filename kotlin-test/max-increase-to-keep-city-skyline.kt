package maxincreasetokeepcityskyline

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxIncreaseToKeepCitySkylineTest {
    private val solution = Solution()

    @Test
    fun computesExample() {
        val grid = arrayOf(
            intArrayOf(3, 0, 8, 4), intArrayOf(2, 4, 5, 7),
            intArrayOf(9, 2, 6, 3), intArrayOf(0, 3, 1, 0)
        )
        assertEquals(35, solution.maxIncreaseKeepingSkyline(grid))
    }

    @Test
    fun returnsZeroWhenNoIncreaseIsPossible() {
        val grid = arrayOf(intArrayOf(2, 2), intArrayOf(2, 2))
        assertEquals(0, solution.maxIncreaseKeepingSkyline(grid))
    }

    @Test
    fun handlesSingleCell() {
        assertEquals(0, solution.maxIncreaseKeepingSkyline(arrayOf(intArrayOf(9))))
    }

    @Test
    fun handlesSingleRow() {
        assertEquals(0, solution.maxIncreaseKeepingSkyline(arrayOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun computesSmallNonsymmetricGrid() {
        val grid = arrayOf(intArrayOf(1, 3), intArrayOf(2, 1))
        assertEquals(2, solution.maxIncreaseKeepingSkyline(grid))
    }
}
