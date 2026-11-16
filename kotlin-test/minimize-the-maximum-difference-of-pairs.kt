package minimizethemaximumdifferenceofpairs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeTheMaximumDifferenceOfPairsTest {
    private val solution = Solution()

    @Test
    fun formsTwoPairsWithMaximumDifferenceOne() {
        assertEquals(1, solution.minimizeMax(intArrayOf(10, 1, 2, 7, 1, 3), 2))
    }

    @Test
    fun usesDuplicateValuesForZeroDifference() {
        assertEquals(0, solution.minimizeMax(intArrayOf(4, 2, 1, 2), 1))
    }

    @Test
    fun returnsZeroWhenNoPairsAreRequired() {
        assertEquals(0, solution.minimizeMax(intArrayOf(42), 0))
    }

    @Test
    fun handlesNegativeValuesAndDisjointPairs() {
        assertEquals(4, solution.minimizeMax(intArrayOf(-8, -4, -3, 0), 2))
    }
}
