package buildarraywhereyoucanfindthemaximumexactlykcomparisons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisonsTest {
    @Test
    fun twoElementsAndOneComparison() {
        assertEquals(6, Solution().numOfArrays(2, 3, 1))
    }

    @Test
    fun exactSearchCostWithTwoValues() {
        assertEquals(15, Solution().numOfArrays(5, 2, 2))
    }

    @Test
    fun onlyOnePossibleMaximum() {
        assertEquals(1, Solution().numOfArrays(9, 1, 1))
    }

    @Test
    fun singleElementCanUseAnyValue() {
        assertEquals(5, Solution().numOfArrays(1, 5, 1))
    }
}
