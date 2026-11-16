package differenceofnumberofdistinctvaluesondiagonals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DifferenceOfNumberOfDistinctValuesOnDiagonalsTest {
    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 1, 5),
            intArrayOf(3, 2, 1)
        )
        val expected = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 1)
        )
        assertArrayEquals(expected, Solution().differenceOfDistinctValues(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(intArrayOf(1))
        val expected = arrayOf(intArrayOf(0))
        assertArrayEquals(expected, Solution().differenceOfDistinctValues(grid))
    }

    @Test
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(1, 2, 1))
        val expected = arrayOf(intArrayOf(0, 0, 0))
        assertArrayEquals(expected, Solution().differenceOfDistinctValues(grid))
    }

    @Test
    fun testSingleColumn() {
        val grid = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(1))
        val expected = arrayOf(intArrayOf(0), intArrayOf(0), intArrayOf(0))
        assertArrayEquals(expected, Solution().differenceOfDistinctValues(grid))
    }

    @Test
    fun testAllSame() {
        val grid = arrayOf(
            intArrayOf(5, 5),
            intArrayOf(5, 5)
        )
        val expected = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        assertArrayEquals(expected, Solution().differenceOfDistinctValues(grid))
    }
}
