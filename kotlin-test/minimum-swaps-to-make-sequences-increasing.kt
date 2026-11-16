package minimumswapstomakesequencesincreasing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToMakeSequencesIncreasingTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(1, solution.minSwap(intArrayOf(1, 3, 5, 4), intArrayOf(1, 2, 3, 7)))
    }

    @Test
    fun testSecondExample() {
        assertEquals(1, solution.minSwap(intArrayOf(0, 3, 5, 8, 9), intArrayOf(2, 1, 4, 6, 9)))
        assertEquals(1, solution.minSwap(intArrayOf(0, 4, 4, 5, 9), intArrayOf(0, 1, 6, 8, 10)))
    }

    @Test
    fun testAlreadyIncreasing() {
        assertEquals(0, solution.minSwap(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minSwap(intArrayOf(5), intArrayOf(3)))
    }
}
