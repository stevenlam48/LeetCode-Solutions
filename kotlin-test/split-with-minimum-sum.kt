package splitwithminimumsum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SplitWithMinimumSumTest {
    private val solution = Solution()

    @Test
    fun zeroProducesAnEmptyDigitListAndZeroResult() {
        assertEquals(0, solution.splitNum(0))
    }

    @Test
    fun powerOfTenProducesOne() {
        assertEquals(1, solution.splitNum(1000))
    }

    @Test
    fun followsReferenceForFirstLeetCodeExample() {
        assertEquals(59, solution.splitNum(4325))
    }

    @Test
    fun followsReferenceForSecondLeetCodeExample() {
        assertEquals(75, solution.splitNum(687))
    }
}
