package maximumvalueofconcatenatedbinarysegments

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueOfConcatenatedBinarySegmentsTest {
    private val solution = Solution()

    @Test
    fun mixedLeadingOnesAndSegments() {
        assertEquals(246, solution.maxValue(intArrayOf(1, 2, 3), intArrayOf(0, 1, 1)))
    }

    @Test
    fun singleAllOnesSegment() {
        assertEquals(3, solution.maxValue(intArrayOf(2), intArrayOf(0)))
    }

    @Test
    fun singleAllZerosSegment() {
        assertEquals(0, solution.maxValue(intArrayOf(0), intArrayOf(3)))
    }

    @Test
    fun equalSegmentsAreConcatenatedInAnyOrder() {
        assertEquals(10, solution.maxValue(intArrayOf(1, 1), intArrayOf(1, 1)))
    }

    @Test
    fun leadingBlockAndOneSegment() {
        assertEquals(60, solution.maxValue(intArrayOf(3, 1), intArrayOf(0, 2)))
    }
}
