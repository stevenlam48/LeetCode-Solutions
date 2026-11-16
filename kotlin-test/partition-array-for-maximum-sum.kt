package partitionarrayformaximumsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayForMaximumSumTest {
    @Test
    fun testExampleOne() {
        assertEquals(84, Solution().maxSumAfterPartitioning(intArrayOf(1, 15, 7, 9, 2, 5, 10), 3))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(72, Solution().maxSumAfterPartitioning(intArrayOf(1, 4, 1, 5, 7, 3, 6, 1, 9, 3), 4))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().maxSumAfterPartitioning(intArrayOf(1), 1))
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(10, Solution().maxSumAfterPartitioning(intArrayOf(1, 2, 3, 4), 1))
    }

    @Test
    fun testKLargerThanArray() {
        assertEquals(9, Solution().maxSumAfterPartitioning(intArrayOf(3, 1, 2), 10))
    }
}
