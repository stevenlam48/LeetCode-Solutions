package closestequalelementqueries

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClosestEqualElementQueriesTest {
    @Test
    fun circularDistancesAndUniqueValues() {
        assertArrayEquals(
            intArrayOf(2, 3, 2, -1, 2, 3, -1),
            Solution().solveQueries(
                intArrayOf(1, 3, 1, 4, 1, 3, 2),
                intArrayOf(0, 1, 2, 3, 4, 5, 6)
            )
        )
    }

    @Test
    fun noDuplicateValues() {
        assertArrayEquals(
            intArrayOf(-1, -1, -1, -1),
            Solution().solveQueries(intArrayOf(1, 2, 3, 4), intArrayOf(0, 1, 2, 3))
        )
    }

    @Test
    fun duplicatesAcrossCircularBoundary() {
        assertArrayEquals(
            intArrayOf(1, -1, 1),
            Solution().solveQueries(intArrayOf(-1, 0, -1), intArrayOf(0, 1, 2))
        )
    }

    @Test
    fun allValuesAreEqual() {
        assertArrayEquals(
            intArrayOf(1, 1, 1, 1),
            Solution().solveQueries(intArrayOf(2, 2, 2, 2), intArrayOf(0, 1, 2, 3))
        )
    }
}
