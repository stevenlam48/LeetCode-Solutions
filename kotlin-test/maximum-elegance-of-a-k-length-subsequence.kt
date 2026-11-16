package maximumeleganceofaklengthsubsequence
// Time:  O(nlogk)
// Space: O(k)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEleganceOfAKLengthSubsequenceTest {
    private val solution = Solution()

    @Test
    fun maximumProfitPairAlsoHasDistinctCategories() {
        val items = arrayOf(intArrayOf(3, 2), intArrayOf(2, 1), intArrayOf(1, 3))
        assertEquals(9L, solution.findMaximumElegance(items, 2))
    }

    @Test
    fun singleItemSubsequence() {
        val items = arrayOf(intArrayOf(4, 1), intArrayOf(7, 2))
        assertEquals(8L, solution.findMaximumElegance(items, 1))
    }

    @Test
    fun replacesDuplicateCategoryForMoreElegance() {
        val items = arrayOf(
            intArrayOf(10, 1),
            intArrayOf(9, 1),
            intArrayOf(8, 2),
            intArrayOf(7, 3)
        )
        assertEquals(22L, solution.findMaximumElegance(items, 2))
    }

    @Test
    fun performsMultipleCategoryReplacements() {
        val items = arrayOf(
            intArrayOf(6, 1),
            intArrayOf(5, 1),
            intArrayOf(4, 1),
            intArrayOf(3, 2),
            intArrayOf(2, 3)
        )
        assertEquals(20L, solution.findMaximumElegance(items, 3))
    }
}
