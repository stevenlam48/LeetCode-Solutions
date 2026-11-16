package maximumteamsizewithoverlappingintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTeamSizeWithOverlappingIntervalsTest {
    private val solution = Solution()

    @Test
    fun allIntervalsOverlap() {
        assertEquals(3, solution.maximumTeamSize(intArrayOf(1, 2, 3), intArrayOf(3, 3, 3)))
    }

    @Test
    fun disjointIntervals() {
        assertEquals(1, solution.maximumTeamSize(intArrayOf(1, 5), intArrayOf(2, 6)))
    }

    @Test
    fun touchingIntervals() {
        assertEquals(2, solution.maximumTeamSize(intArrayOf(1, 2), intArrayOf(2, 3)))
    }

    @Test
    fun singleInterval() {
        assertEquals(1, solution.maximumTeamSize(intArrayOf(1), intArrayOf(1)))
    }
}
