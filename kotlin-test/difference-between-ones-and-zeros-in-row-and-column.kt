package differencebetweenonesandzerosinrowandcolumn

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DifferenceBetweenOnesAndZerosInRowAndColumnTest {
    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 1)
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 4),
            intArrayOf(0, 0, 4),
            intArrayOf(-2, -2, 2)
        )
        val actual = Solution().onesMinusZeros(grid)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5)
        )
        assertArrayEquals(expected, Solution().onesMinusZeros(grid))
    }

    @Test
    fun testSingleCell() {
        assertArrayEquals(arrayOf(intArrayOf(2)), Solution().onesMinusZeros(arrayOf(intArrayOf(1))))
        assertArrayEquals(arrayOf(intArrayOf(-2)), Solution().onesMinusZeros(arrayOf(intArrayOf(0))))
    }

    @Test
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(0, 1, 0))
        val expected = arrayOf(intArrayOf(-2, 0, -2))
        assertArrayEquals(expected, Solution().onesMinusZeros(grid))
    }
}
