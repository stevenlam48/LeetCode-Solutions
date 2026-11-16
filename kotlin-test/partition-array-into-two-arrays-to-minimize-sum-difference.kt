package partitionarrayintotwoarraystominimizesumdifference

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayIntoTwoArraysToMinimizeSumDifferenceTest {
    @Test
    fun testExampleOne() {
        assertEquals(2, Solution().minimumDifference(intArrayOf(3, 9, 7, 3)))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(72, Solution().minimumDifference(intArrayOf(-36, 36)))
    }

    @Test
    fun testZeroDifference() {
        assertEquals(0, Solution().minimumDifference(intArrayOf(2, -1, 0, 4, -2, -9)))
    }

    @Test
    fun testEvenSplit() {
        assertEquals(0, Solution().minimumDifference(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(0, Solution().minimumDifference(intArrayOf(5, 5)))
    }

    @Test
    fun testNegatives() {
        assertEquals(1, Solution().minimumDifference(intArrayOf(-1, 0)))
    }
}
