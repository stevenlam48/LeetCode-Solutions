package partitionarraysuchthatmaximumdifferenceisk

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArraySuchThatMaximumDifferenceIsKTest {
    @Test
    fun testExampleOne() {
        assertEquals(2, Solution().partitionArray(intArrayOf(3, 6, 1, 2, 5), 2))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(2, Solution().partitionArray(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun testKZero() {
        assertEquals(3, Solution().partitionArray(intArrayOf(2, 2, 4, 5), 0))
    }

    @Test
    fun testAllWithinK() {
        assertEquals(1, Solution().partitionArray(intArrayOf(1, 2, 3, 4, 5), 10))
    }

    @Test
    fun testNegativeNumbers() {
        assertEquals(2, Solution().partitionArray(intArrayOf(-5, -3, 1, 2), 2))
    }
}
