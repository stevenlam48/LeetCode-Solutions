package countgoodintegersonagridpath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodIntegersOnAGridPathTest {
    private val solution = Solution()

    @Test
    fun emptyPathLeavesAllValuesUnrestricted() {
        assertEquals(20L, solution.countGoodIntegersOnPath(1, 20, ""))
    }

    @Test
    fun rejectsDecreasingDigitsAtVisitedPositions() {
        assertEquals(0L, solution.countGoodIntegersOnPath(100000000000, 100000000000, "DDD"))
    }

    @Test
    fun shortPathOnlyRestrictsLeadingDigits() {
        assertEquals(100000000001L, solution.countGoodIntegersOnPath(0, 100000000000, "D"))
    }

    @Test
    fun includesZeroInClosedRange() {
        assertEquals(10L, solution.countGoodIntegersOnPath(0, 9, "RRR"))
    }
}
