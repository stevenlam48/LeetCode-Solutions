package widestpairofindiceswithequalrangesum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WidestPairOfIndicesWithEqualRangeSumTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(
            3,
            solution.widestPairOfIndices(intArrayOf(1, 1, 0, 1), intArrayOf(0, 1, 1, 0))
        )
    }

    @Test
    fun example2() {
        assertEquals(1, solution.widestPairOfIndices(intArrayOf(0, 1), intArrayOf(1, 1)))
    }

    @Test
    fun example3() {
        assertEquals(0, solution.widestPairOfIndices(intArrayOf(0), intArrayOf(1)))
    }

    @Test
    fun identicalArrays() {
        assertEquals(
            3,
            solution.widestPairOfIndices(intArrayOf(1, 0, 1), intArrayOf(1, 0, 1))
        )
        assertEquals(3, solution.widestPairOfIndices(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)))
    }

    @Test
    fun wholeArrayMatches() {
        assertEquals(2, solution.widestPairOfIndices(intArrayOf(1, 0), intArrayOf(0, 1)))
    }

    @Test
    fun noMatchingRange() {
        assertEquals(
            0,
            solution.widestPairOfIndices(intArrayOf(0, 0, 0), intArrayOf(1, 1, 1))
        )
    }
}
