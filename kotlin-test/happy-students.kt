package happystudents

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HappyStudentsTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(2, solution.countWays(intArrayOf(1, 1)))
        assertEquals(3, solution.countWays(intArrayOf(6, 0, 3, 3, 6, 7, 2, 7)))
    }

    @Test
    fun emptySelectionIsOnlyOption() {
        assertEquals(1, solution.countWays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allZerosAllowEveryGroupSize() {
        assertEquals(1, solution.countWays(intArrayOf(0, 0)))
    }

    @Test
    fun singleStudent() {
        assertEquals(1, solution.countWays(intArrayOf(1)))
        assertEquals(1, solution.countWays(intArrayOf(0)))
    }
}
