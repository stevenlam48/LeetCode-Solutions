package maximumsumqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumSumQueriesTest {
    private val solution = Solution()

    @Test
    fun mixedQueries() {
        assertArrayEquals(
            intArrayOf(4, 4, -1),
            solution.maximumSumQueries(
                intArrayOf(1, 2, 3),
                intArrayOf(3, 2, 1),
                arrayOf(intArrayOf(2, 2), intArrayOf(1, 1), intArrayOf(3, 3))
            )
        )
    }

    @Test
    fun singleQuery() {
        assertArrayEquals(
            intArrayOf(8),
            solution.maximumSumQueries(
                intArrayOf(5, 1, 4),
                intArrayOf(1, 5, 4),
                arrayOf(intArrayOf(2, 2))
            )
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(
            intArrayOf(2, -1),
            solution.maximumSumQueries(
                intArrayOf(1),
                intArrayOf(1),
                arrayOf(intArrayOf(1, 1), intArrayOf(2, 2))
            )
        )
    }

    @Test
    fun noPairSatisfiesQuery() {
        assertArrayEquals(
            intArrayOf(-1),
            solution.maximumSumQueries(
                intArrayOf(1, 2),
                intArrayOf(1, 2),
                arrayOf(intArrayOf(3, 3))
            )
        )
    }
}
