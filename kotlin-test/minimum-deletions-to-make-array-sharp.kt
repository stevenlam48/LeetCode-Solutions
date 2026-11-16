package minimumdeletionstomakearraysharp
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDeletionsToMakeArraySharpTest {
    private val solution = Solution()

    @Test
    fun separateAdjacentPairs() {
        assertEquals(2, solution.minDeletions(intArrayOf(1, 1, 2, 3, 3)))
    }

    @Test
    fun repeatedRunCountsEveryAdjacentPair() {
        assertEquals(2, solution.minDeletions(intArrayOf(5, 5, 5)))
    }

    @Test
    fun noDeletionsNeeded() {
        assertEquals(0, solution.minDeletions(intArrayOf(1, 2, 1)))
        assertEquals(0, solution.minDeletions(intArrayOf(7)))
        assertEquals(0, solution.minDeletions(intArrayOf()))
    }
}
