package minimumcosttomaketwobinarystringsequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToMakeTwoBinaryStringsEqualTest {
    private val solution = Solution()

    @Test
    fun equalStrings() {
        assertEquals(0L, solution.minimumCost("0011", "0011", 1, 2, 3))
    }

    @Test
    fun balancedMismatchesUseSwaps() {
        assertEquals(4L, solution.minimumCost("0011", "1100", 1, 2, 3))
    }

    @Test
    fun individualFlipsCanBeCheaperThanSwaps() {
        assertEquals(2L, solution.minimumCost("01", "10", 1, 5, 3))
    }

    @Test
    fun unmatchedPairsUseCrossOperations() {
        assertEquals(8L, solution.minimumCost("0000", "1111", 5, 3, 1))
    }

    @Test
    fun oddMismatchRemainder() {
        assertEquals(9L, solution.minimumCost("000", "111", 5, 3, 1))
    }
}
