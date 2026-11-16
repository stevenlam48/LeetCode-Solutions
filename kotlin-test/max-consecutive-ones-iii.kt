package maxconsecutiveonesiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesIiiTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        val nums = intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0)
        assertEquals(6, solution.longestOnes(nums, 2))
    }

    @Test
    fun computesSecondExample() {
        val nums = intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1)
        assertEquals(10, solution.longestOnes(nums, 3))
    }

    @Test
    fun zeroFlipsFindsLongestNaturalRun() {
        assertEquals(3, solution.longestOnes(intArrayOf(1, 1, 0, 1, 1, 1, 0), 0))
    }

    @Test
    fun canFlipEveryZero() {
        assertEquals(4, solution.longestOnes(intArrayOf(0, 0, 0, 0), 4))
    }

    @Test
    fun handlesAllOnes() {
        assertEquals(3, solution.longestOnes(intArrayOf(1, 1, 1), 0))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.longestOnes(intArrayOf(), 2))
    }
}
