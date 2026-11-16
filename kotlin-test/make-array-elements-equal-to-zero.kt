package makearrayelementsequaltozero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MakeArrayElementsEqualToZeroTest {
    @Test
    fun countsBothDirectionsAtBalancedZero() {
        assertEquals(2, Solution().countValidSelections(intArrayOf(1, 0, 2, 0, 3)))
    }

    @Test
    fun eachZeroInAllZeroArrayHasTwoSelections() {
        assertEquals(6, Solution().countValidSelections(intArrayOf(0, 0, 0)))
    }

    @Test
    fun adjacentZerosWithOneUnitDifferenceAllowOneDirectionEach() {
        assertEquals(2, Solution().countValidSelections(intArrayOf(2, 3, 0, 0, 4)))
    }

    @Test
    fun arraysWithoutZerosHaveNoSelections() {
        assertEquals(0, Solution().countValidSelections(intArrayOf(1, 2, 3)))
    }

    @Test
    fun handlesSingleZeroAndSingleNonZero() {
        assertEquals(2, Solution().countValidSelections(intArrayOf(0)))
        assertEquals(0, Solution().countValidSelections(intArrayOf(7)))
    }
}
