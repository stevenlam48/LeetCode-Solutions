package minimumpairremovaltosortarrayi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPairRemovalToSortArrayITest {
    private val solution = Solution()

    @Test
    fun handlesLeetCodeExample() {
        assertEquals(2, solution.minimumPairRemoval(intArrayOf(5, 2, 3, 1)))
    }

    @Test
    fun handlesAlreadySortedArray() {
        assertEquals(0, solution.minimumPairRemoval(intArrayOf(1, 2, 2)))
    }

    @Test
    fun handlesEmptyArray() {
        assertEquals(0, solution.minimumPairRemoval(intArrayOf()))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(0, solution.minimumPairRemoval(intArrayOf(7)))
    }

    @Test
    fun mergesTheSmallestPair() {
        assertEquals(1, solution.minimumPairRemoval(intArrayOf(3, 2, 1)))
    }

    @Test
    fun handlesNegativeValuesAndMergesCreatingAnInversion() {
        assertEquals(2, solution.minimumPairRemoval(intArrayOf(2, 2, -1, 1)))
    }
}
