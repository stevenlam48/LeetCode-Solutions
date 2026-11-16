package countpartitionswithevensumdifference

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPartitionsWithEvenSumDifferenceTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4, solution.countPartitions(intArrayOf(10, 10, 3, 7, 6)))
    }

    @Test
    fun noValidPartition() {
        assertEquals(0, solution.countPartitions(intArrayOf(1, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.countPartitions(intArrayOf(1)))
    }
}
