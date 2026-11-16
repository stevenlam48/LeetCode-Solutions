package minimumswapstogroupall1stogether

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToGroupAll1sTogetherTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(1, solution.minSwaps(intArrayOf(1, 0, 1, 0, 1)))
    }

    @Test
    fun testAllZeroes() {
        assertEquals(0, solution.minSwaps(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testAllOnes() {
        assertEquals(0, solution.minSwaps(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun testSeparatedGroups() {
        assertEquals(2, solution.minSwaps(intArrayOf(1, 1, 0, 0, 1, 1, 0, 0, 1, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minSwaps(intArrayOf(1)))
        assertEquals(0, solution.minSwaps(intArrayOf(0)))
    }
}
