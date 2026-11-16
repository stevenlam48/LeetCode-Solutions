package partitionarrayintothreepartswithequalsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayIntoThreePartsWithEqualSumTest {
    @Test
    fun testExampleOne() {
        assertTrue(Solution().canThreePartsEqualSum(intArrayOf(0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1)))
    }

    @Test
    fun testExampleTwo() {
        assertFalse(Solution().canThreePartsEqualSum(intArrayOf(0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1)))
    }

    @Test
    fun testExampleThree() {
        assertTrue(Solution().canThreePartsEqualSum(intArrayOf(3, 3, 6, 5, -2, 2, 5, 1, -9, 4)))
    }

    @Test
    fun testAllZeros() {
        assertTrue(Solution().canThreePartsEqualSum(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testTooShort() {
        assertFalse(Solution().canThreePartsEqualSum(intArrayOf(1, 1)))
        assertFalse(Solution().canThreePartsEqualSum(intArrayOf(1, 2, 3)))
    }
}
