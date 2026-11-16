package partitionarrayaccordingtogivenpivot

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayAccordingToGivenPivotTest {
    @Test
    fun testExample() {
        val nums = intArrayOf(9, 12, 5, 10, 14, 3, 10)
        assertArrayEquals(
            intArrayOf(9, 5, 3, 10, 10, 12, 14),
            Solution().pivotArray(nums, 10)
        )
    }

    @Test
    fun testAlreadyPartitioned() {
        assertArrayEquals(
            intArrayOf(1, 2, 3),
            Solution().pivotArray(intArrayOf(1, 2, 3), 2)
        )
    }

    @Test
    fun testNegatives() {
        assertArrayEquals(
            intArrayOf(-3, 2, 4, 3),
            Solution().pivotArray(intArrayOf(-3, 4, 3, 2), 2)
        )
    }

    @Test
    fun testAllGreaterThanPivot() {
        assertArrayEquals(
            intArrayOf(5, 6, 7),
            Solution().pivotArray(intArrayOf(5, 6, 7), 1)
        )
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(
            intArrayOf(4),
            Solution().pivotArray(intArrayOf(4), 4)
        )
    }
}
