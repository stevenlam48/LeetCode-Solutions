package minimumswapstogroupall1stogetherii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToGroupAll1sTogetherIiTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(1, solution.minSwaps(intArrayOf(0, 1, 0, 1, 1, 0, 0)))
        assertEquals(2, solution.minSwaps(intArrayOf(0, 1, 1, 1, 0, 0, 1, 1, 0)))
    }

    @Test
    fun testAlreadyGrouped() {
        assertEquals(0, solution.minSwaps(intArrayOf(1, 1, 0, 0, 1)))
        assertEquals(0, solution.minSwaps(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testAllZeroes() {
        assertEquals(0, solution.minSwaps(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testAlternating() {
        assertEquals(1, solution.minSwaps(intArrayOf(1, 0, 1, 0, 1)))
        assertEquals(1, solution.minSwaps(intArrayOf(1, 0, 0, 1, 1, 0, 1)))
    }
}
