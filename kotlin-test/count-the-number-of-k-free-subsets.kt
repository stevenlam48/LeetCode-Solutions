package countthenumberofkfreesubsets
// Time:  O(n)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfKFreeSubsetsTest {
    @Test
    fun example() {
        assertEquals(5L, Solution().countTheNumOfKFreeSubsets(intArrayOf(5, 4, 6), 1))
    }

    @Test
    fun duplicateValuesAreDistinctChoices() {
        assertEquals(7L, Solution().countTheNumOfKFreeSubsets(intArrayOf(2, 3, 3, 4), 1))
    }

    @Test
    fun allValuesEqual() {
        assertEquals(8L, Solution().countTheNumOfKFreeSubsets(intArrayOf(7, 7, 7), 2))
    }

    @Test
    fun emptyInputCountsEmptySubset() {
        assertEquals(1L, Solution().countTheNumOfKFreeSubsets(intArrayOf(), 3))
    }
}
