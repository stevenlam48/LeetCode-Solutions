package countpartitionswithmaxmindifferenceatmostk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPartitionsWithMaxMinDifferenceAtMostKTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(6, solution.countPartitions(intArrayOf(9, 4, 1, 3, 7), 4))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, solution.countPartitions(intArrayOf(3, 3, 4), 0))
    }

    @Test
    fun noTwoElementsCanShareAPartition() {
        assertEquals(1, solution.countPartitions(intArrayOf(1, 5, 9), 3))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.countPartitions(intArrayOf(7), 0))
    }
}
