package coloringaborder

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ColoringABorderTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 2))
        val expected = arrayOf(intArrayOf(3, 3), intArrayOf(3, 2))
        val result = solution.colorBorder(grid, 0, 0, 3)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(1, 2, 2), intArrayOf(2, 3, 2)
        )
        val expected = arrayOf(
            intArrayOf(1, 3, 3), intArrayOf(2, 3, 3)
        )
        val result = solution.colorBorder(grid, 0, 1, 3)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
    }

    @Test
    fun testInteriorNotColored() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)
        )
        val expected = arrayOf(
            intArrayOf(2, 2, 2), intArrayOf(2, 1, 2), intArrayOf(2, 2, 2)
        )
        val result = solution.colorBorder(grid, 1, 1, 2)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], result[i])
        }
    }

    @Test
    fun testSingleCell() {
        val grid = arrayOf(intArrayOf(1))
        val result = solution.colorBorder(grid, 0, 0, 5)
        assertArrayEquals(intArrayOf(5), result[0])
    }

    @Test
    fun testDifferentColorNeighbor() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(2, 1))
        val expected = arrayOf(intArrayOf(3, 2), intArrayOf(2, 1))
        val result = solution.colorBorder(grid, 0, 0, 3)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
    }
}
