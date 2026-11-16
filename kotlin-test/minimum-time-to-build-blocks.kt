package minimumtimetobuildblocks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeToBuildBlocksTest {
    private val solution = Solution()

    @Test
    fun testStandardExample() {
        assertEquals(4, solution.minBuildTime(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun testSingleBlock() {
        assertEquals(1, solution.minBuildTime(intArrayOf(1), 5))
        assertEquals(10, solution.minBuildTime(intArrayOf(10), 1))
    }

    @Test
    fun testFourBlocks() {
        assertEquals(5, solution.minBuildTime(intArrayOf(1, 2, 3, 4), 1))
    }

    @Test
    fun testTwoBlocks() {
        assertEquals(25, solution.minBuildTime(intArrayOf(10, 20), 5))
        assertEquals(11, solution.minBuildTime(intArrayOf(1, 1), 10))
    }
}
