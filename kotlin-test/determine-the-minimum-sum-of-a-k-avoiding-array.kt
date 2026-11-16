package determinetheminimumsumofakavoidingarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DetermineTheMinimumSumOfAKAvoidingArrayTest {
    private val solution = Solution()

    @Test
    fun firstTwoAndFiveFormMinimumArray() {
        assertEquals(18, solution.minimumSum(5, 4))
    }

    @Test
    fun noAvoidingPairRestrictsInitialChoices() {
        assertEquals(3, solution.minimumSum(2, 6))
    }

    @Test
    fun singleElementAlwaysUsesOne() {
        assertEquals(1, solution.minimumSum(1, 2))
    }

    @Test
    fun allInitialValuesFitBeforeK() {
        assertEquals(15, solution.minimumSum(5, 10))
    }
}
