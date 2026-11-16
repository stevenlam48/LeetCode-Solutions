package counthillsandvalleysinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountHillsAndValleysInAnArrayTest {
    private val solution = Solution()

    @Test
    fun countsFirstExampleWithPlateaus() {
        assertEquals(3, solution.countHillValley(intArrayOf(2, 4, 1, 1, 6, 5)))
    }

    @Test
    fun monotoneDecreasingArrayHasNoTurningPoint() {
        assertEquals(0, solution.countHillValley(intArrayOf(6, 6, 5, 5, 4, 1)))
    }

    @Test
    fun twoElementsHaveNoInterior() {
        assertEquals(0, solution.countHillValley(intArrayOf(1, 2)))
    }
}
