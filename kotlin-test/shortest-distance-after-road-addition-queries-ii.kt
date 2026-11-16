package shortestdistanceafterroadadditionqueriesii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestDistanceAfterRoadAdditionQueriesIiTest {
    @Test
    fun removesSkippedIntermediateCities() {
        val queries = arrayOf(intArrayOf(2, 4), intArrayOf(0, 2), intArrayOf(0, 4))
        assertArrayEquals(intArrayOf(3, 2, 1), Solution().shortestDistanceAfterQueries(5, queries))
    }

    @Test
    fun handlesImmediateShortcut() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(1, 1), Solution().shortestDistanceAfterQueries(4, queries))
    }

    @Test
    fun handlesEmptyAndOverlappingQueries() {
        assertArrayEquals(intArrayOf(), Solution().shortestDistanceAfterQueries(5, emptyArray()))
        val queries = arrayOf(intArrayOf(1, 4), intArrayOf(0, 2), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(2, 1, 1), Solution().shortestDistanceAfterQueries(5, queries))
    }
}
