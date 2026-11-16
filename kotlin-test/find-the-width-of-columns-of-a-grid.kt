package findthewidthofcolumnsofagrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheWidthOfColumnsOfAGridTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(intArrayOf(1), intArrayOf(22), intArrayOf(333))
        assertArrayEquals(intArrayOf(3), solution.findColumnWidth(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(-15, 1, 3),
            intArrayOf(15, 7, 12),
            intArrayOf(5, 6, 10)
        )
        assertArrayEquals(intArrayOf(3, 1, 2), solution.findColumnWidth(grid))
    }

    @Test
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(1, 22, 333))
        assertArrayEquals(intArrayOf(1, 2, 3), solution.findColumnWidth(grid))
    }

    @Test
    fun testNegativeNumbers() {
        val grid = arrayOf(intArrayOf(-1000, 0), intArrayOf(1, -1))
        assertArrayEquals(intArrayOf(5, 2), solution.findColumnWidth(grid))
    }
}
