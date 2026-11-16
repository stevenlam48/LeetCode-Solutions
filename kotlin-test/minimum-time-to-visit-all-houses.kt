package minimumtimetovisitallhouses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToVisitAllHousesTest {
    @Test
    fun mixedQueryDirections() {
        val result = Solution().minTotalTime(intArrayOf(2, 3, 4), intArrayOf(5, 6, 7), intArrayOf(1, 2, 0, 2))
        assertEquals(14L, result)
    }

    @Test
    fun forwardDirectionIsCheaper() {
        val result = Solution().minTotalTime(intArrayOf(1, 1, 1), intArrayOf(10, 10, 10), intArrayOf(1, 2, 0))
        assertEquals(3L, result)
    }

    @Test
    fun backwardDirectionIsCheaper() {
        val result = Solution().minTotalTime(intArrayOf(10, 10, 10), intArrayOf(1, 2, 3), intArrayOf(2, 0))
        assertEquals(6L, result)
    }

    @Test
    fun noQueries() {
        assertEquals(0L, Solution().minTotalTime(intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf()))
    }
}
