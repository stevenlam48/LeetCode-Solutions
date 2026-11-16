package minimumcosttomergesortedlists

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMergeSortedListsTest {
    private val solution = Solution()

    @Test
    fun oneListNeedsNoMerges() {
        assertEquals(0L, solution.minMergeCost(listOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun twoEqualLengthLists() {
        assertEquals(5L, solution.minMergeCost(listOf(intArrayOf(1, 3), intArrayOf(2, 4))))
    }

    @Test
    fun disjointValues() {
        assertEquals(24L, solution.minMergeCost(listOf(intArrayOf(1, 2, 3), intArrayOf(10, 20, 30))))
    }

    @Test
    fun duplicateValuesAcrossLists() {
        assertEquals(4L, solution.minMergeCost(listOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }
}
