package minimumcosttoequalizearray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToEqualizeArrayTest {
    private val solution = Solution()

    @Test
    fun twoElementsOnlyUseSingleOperations() {
        assertEquals(6, solution.minCostToEqualizeArray(intArrayOf(1, 4), 2, 1))
    }

    @Test
    fun mixedSingleAndPairedOperations() {
        assertEquals(11, solution.minCostToEqualizeArray(intArrayOf(2, 3, 3, 3, 5), 3, 2))
    }

    @Test
    fun allEqualArray() {
        assertEquals(0, solution.minCostToEqualizeArray(intArrayOf(4, 4, 4), 5, 1))
    }

    @Test
    fun pairCostTooExpensive() {
        assertEquals(9, solution.minCostToEqualizeArray(intArrayOf(1, 4, 4), 3, 7))
    }
}
