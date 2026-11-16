package minimumcosttomergestones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMergeStonesTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(20, solution.mergeStones(intArrayOf(3, 2, 4, 1), 2))
    }

    @Test
    fun impossibleMerge() {
        assertEquals(-1, solution.mergeStones(intArrayOf(3, 2, 4, 1), 3))
    }

    @Test
    fun thirdLeetCodeExample() {
        assertEquals(25, solution.mergeStones(intArrayOf(3, 5, 1, 2, 6), 3))
    }

    @Test
    fun singlePileNeedsNoMerge() {
        assertEquals(0, solution.mergeStones(intArrayOf(7), 2))
    }
}
