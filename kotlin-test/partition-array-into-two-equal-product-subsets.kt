package partitionarrayintotwoequalproductsubsets

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayIntoTwoEqualProductSubsetsTest {
    @Test
    fun testExampleOne() {
        assertTrue(Solution().checkEqualPartitions(intArrayOf(3, 1, 6, 8, 4), 24))
    }

    @Test
    fun testExampleTwo() {
        assertTrue(Solution().checkEqualPartitions(intArrayOf(2, 3, 4, 6), 12))
    }

    @Test
    fun testNoSubsetWithTargetProduct() {
        assertFalse(Solution().checkEqualPartitions(intArrayOf(1, 1, 4), 2))
    }

    @Test
    fun testProductNotSquare() {
        assertFalse(Solution().checkEqualPartitions(intArrayOf(2, 3, 5), 5))
    }

    @Test
    fun testTargetOne() {
        assertTrue(Solution().checkEqualPartitions(intArrayOf(1, 1), 1))
    }

    @Test
    fun testTwoElements() {
        assertTrue(Solution().checkEqualPartitions(intArrayOf(2, 2), 2))
        assertFalse(Solution().checkEqualPartitions(intArrayOf(2, 3), 2))
    }
}
