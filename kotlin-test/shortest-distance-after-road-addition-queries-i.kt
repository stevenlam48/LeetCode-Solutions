package shortestdistanceafterroadadditionqueriesi

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestDistanceAfterRoadAdditionQueriesITest {
    @Test
    fun updatesDistanceAfterEveryQuery() {
        val queries = arrayOf(intArrayOf(2, 4), intArrayOf(0, 2), intArrayOf(0, 4))
        assertArrayEquals(intArrayOf(3, 2, 1), Solution().shortestDistanceAfterQueries(5, queries))
    }

    @Test
    fun handlesImmediateShortcut() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(1, 1), Solution().shortestDistanceAfterQueries(4, queries))
    }

    @Test
    fun handlesEmptyAndRepeatedQueries() {
        assertArrayEquals(intArrayOf(), Solution().shortestDistanceAfterQueries(4, emptyArray()))
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(2, 2), Solution().shortestDistanceAfterQueries(4, queries))
    }
}
