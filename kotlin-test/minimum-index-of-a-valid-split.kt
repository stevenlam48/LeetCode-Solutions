package minimumindexofavalidsplit

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumIndexOfAValidSplitTest {
    @Test
    fun splitAfterDominantPrefix() {
        assertEquals(2, Solution().minimumIndex(intArrayOf(1, 2, 2, 2)))
    }

    @Test
    fun earliestValidSplitIsReturned() {
        assertEquals(4, Solution().minimumIndex(intArrayOf(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)))
    }

    @Test
    fun noSplitCanHaveTheSameDominantValue() {
        assertEquals(-1, Solution().minimumIndex(intArrayOf(3, 3, 3, 3, 7, 2, 2)))
    }

    @Test
    fun zeroCanBeAValidSplit() {
        assertEquals(0, Solution().minimumIndex(intArrayOf(1, 1, 1, 2, 1)))
    }
}
