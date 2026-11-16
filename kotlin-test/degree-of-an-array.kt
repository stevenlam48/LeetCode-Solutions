package degreeofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DegreeOfAnArrayTest {
    private val solution = Solution()

    @Test
    fun choosesShortestAmongMaximumDegreeValues() {
        assertEquals(2, solution.findShortestSubArray(intArrayOf(1, 2, 2, 3, 1)))
    }

    @Test
    fun choosesShortestRangeAmongTies() {
        assertEquals(6, solution.findShortestSubArray(intArrayOf(1, 2, 2, 3, 1, 4, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.findShortestSubArray(intArrayOf(7)))
    }

    @Test
    fun duplicateAndDistinctElements() {
        assertEquals(3, solution.findShortestSubArray(intArrayOf(-1, 4, -1, 4)))
        assertEquals(1, solution.findShortestSubArray(intArrayOf(3, 1, 2)))
    }
}
