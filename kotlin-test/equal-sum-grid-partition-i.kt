package equalsumgridpartitioni

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualSumGridPartitionITest {
    private val solution = Solution()

    @Test
    fun testRowSplit() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(2), intArrayOf(2))))
    }

    @Test
    fun testColumnSplit() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2))))
    }

    @Test
    fun testNoPartition() {
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 3), intArrayOf(2, 4))))
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }

    @Test
    fun testOddTotal() {
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2, 4))))
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(5))))
    }

    @Test
    fun testSingleRow() {
        assertTrue(solution.canPartitionGrid(arrayOf(intArrayOf(1, 1))))
        assertFalse(solution.canPartitionGrid(arrayOf(intArrayOf(1, 2, 1))))
    }
}
