package countnegativenumbersinasortedmatrix

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNegativeNumbersInASortedMatrixTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(4, 3, 2, -1),
            intArrayOf(3, 2, 1, -1),
            intArrayOf(1, 1, -1, -2),
            intArrayOf(-1, -1, -2, -3)
        )
        assertEquals(8, solution.countNegatives(grid))
    }

    @Test
    fun testNoNegatives() {
        val grid = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(1, 0)
        )
        assertEquals(0, solution.countNegatives(grid))
    }

    @Test
    fun testAllNegatives() {
        val grid = arrayOf(
            intArrayOf(1, -1),
            intArrayOf(-1, -1)
        )
        assertEquals(3, solution.countNegatives(grid))
    }
}
