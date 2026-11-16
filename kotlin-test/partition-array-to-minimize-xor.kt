package partitionarraytominimizexor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionArrayToMinimizeXorTest {
    private val solution = Solution()

    @Test
    fun minimizesMaximumXorAcrossThreePartitions() {
        assertEquals(2, solution.minXor(intArrayOf(1, 2, 3, 2), 3))
    }

    @Test
    fun handlesRepeatedValues() {
        assertEquals(2, solution.minXor(intArrayOf(2, 3, 3, 2), 3))
    }

    @Test
    fun handlesSinglePartition() {
        assertEquals(0, solution.minXor(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun handlesAllZeroValues() {
        assertEquals(0, solution.minXor(intArrayOf(0, 0, 0), 2))
    }
}
