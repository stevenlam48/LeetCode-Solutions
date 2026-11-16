package longestharmonioussubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestHarmoniousSubsequenceTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(5, solution.findLHS(intArrayOf(1, 3, 2, 2, 5, 2, 3, 7)))
    }

    @Test
    fun consecutiveValues() {
        assertEquals(5, solution.findLHS(intArrayOf(1, 2, 3, 4, 2, 3, 3)))
    }

    @Test
    fun noHarmoniousPair() {
        assertEquals(0, solution.findLHS(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun negatives() {
        assertEquals(5, solution.findLHS(intArrayOf(-2, -1, -2, -1, -2)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.findLHS(intArrayOf()))
    }
}
