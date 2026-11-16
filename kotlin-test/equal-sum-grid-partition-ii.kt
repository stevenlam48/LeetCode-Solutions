package equalsumgridpartitionii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualSumGridPartitionIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
    }

    @Test
    fun testPartitionWithRemoval() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 3), intArrayOf(2, 4))))
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(4, 10))))
    }

    @Test
    fun testRowSplitWithoutRemoval() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(2), intArrayOf(2))))
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun testSingleRow() {
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2, 4))))
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 1, 2))))
    }

    @Test
    fun testSingleCell() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(5))))
    }

    @Test
    fun testMultipleRows() {
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6))))
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }
}
