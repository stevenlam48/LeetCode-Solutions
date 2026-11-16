package minimizethemaximumadjacentelementdifference

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeTheMaximumAdjacentElementDifferenceTest {
    private val solution = Solution()

    @Test
    fun fillsSingleGapBetweenDistantValues() {
        assertEquals(4, solution.minDifference(intArrayOf(1, 2, -1, 10, 8)))
    }

    @Test
    fun handlesLeadingAndInteriorGaps() {
        assertEquals(1, solution.minDifference(intArrayOf(-1, 10, -1, 8)))
    }

    @Test
    fun retainsMaximumDifferenceWithoutMissingValues() {
        assertEquals(1, solution.minDifference(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun handlesAllValuesMissing() {
        assertEquals(0, solution.minDifference(intArrayOf(-1, -1, -1)))
    }

    @Test
    fun balancesMultipleMissingValuesBetweenEndpoints() {
        assertEquals(2, solution.minDifference(intArrayOf(7, -1, -1, 13)))
    }
}
