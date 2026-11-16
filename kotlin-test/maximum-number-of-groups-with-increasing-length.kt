package maximumnumberofgroupswithincreasinglength

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfGroupsWithIncreasingLengthTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(3, solution.maxIncreasingGroups(intArrayOf(1, 2, 5)))
    }

    @Test
    fun limitsAreClampedToInputSize() {
        assertEquals(2, solution.maxIncreasingGroups(intArrayOf(5, 4)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.maxIncreasingGroups(intArrayOf()))
    }

    @Test
    fun zeroLimits() {
        assertEquals(1, solution.maxIncreasingGroups(intArrayOf(0, 0, 10)))
    }

    @Test
    fun duplicateLimits() {
        assertEquals(3, solution.maxIncreasingGroups(intArrayOf(2, 2, 2, 2)))
    }
}
