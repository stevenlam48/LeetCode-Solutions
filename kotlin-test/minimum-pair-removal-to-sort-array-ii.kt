package minimumpairremovaltosortarrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MinimumPairRemovalToSortArrayIiTest {
    private val solution = Solution()

    @Test
    fun mergesSmallestPairUntilSorted() {
        assertEquals(2, solution.minimumPairRemoval(intArrayOf(5, 2, 3, 1)))
    }

    @Test
    fun handlesSortedAndSingleElementArrays() {
        assertEquals(0, solution.minimumPairRemoval(intArrayOf(1, 2, 2)))
        assertEquals(0, solution.minimumPairRemoval(intArrayOf(7)))
    }

    @Test
    fun mergesNegativePairFirst() {
        assertEquals(3, solution.minimumPairRemoval(intArrayOf(4, -1, -1, 2)))
    }

    @Test
    fun sumsLargeValuesWithoutIntOverflow() {
        assertEquals(2, solution.minimumPairRemoval(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, -Int.MAX_VALUE)))
    }
}
