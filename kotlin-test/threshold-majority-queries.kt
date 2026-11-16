package thresholdmajorityqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ThresholdMajorityQueriesTest {
    private val solution = Solution()

    @Test
    fun thresholdsAndTies() {
        val queries = arrayOf(
            intArrayOf(0, 5, 4),
            intArrayOf(0, 3, 3),
            intArrayOf(1, 4, 2),
            intArrayOf(2, 3, 2)
        )
        assertArrayEquals(intArrayOf(1, -1, 1, 2), solution.subarrayMajority(intArrayOf(1, 1, 2, 2, 1, 1), queries))
    }

    @Test
    fun singleElementQueries() {
        val queries = arrayOf(intArrayOf(0, 0, 1), intArrayOf(2, 2, 2))
        assertArrayEquals(intArrayOf(7, -1), solution.subarrayMajority(intArrayOf(7, 8, 7), queries))
    }

    @Test
    fun smallestValueAmongMostFrequent() {
        val queries = arrayOf(intArrayOf(0, 3, 2))
        assertArrayEquals(intArrayOf(2), solution.subarrayMajority(intArrayOf(5, 2, 5, 2), queries))
    }
}
