package maximizesumofarrayafterknegations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSumOfArrayAfterKNegationsTest {
    private val solution = Solution()

    @Test
    fun negatesTheSmallestPositiveElementForOddK() {
        assertEquals(5, solution.largestSumAfterKNegations(intArrayOf(4, 2, 3), 1))
    }

    @Test
    fun handlesZeroAndAnEvenNumberOfRemainingNegations() {
        assertEquals(6, solution.largestSumAfterKNegations(intArrayOf(3, -1, 0, 2), 3))
    }

    @Test
    fun negatesTheTwoMostNegativeElements() {
        assertEquals(13, solution.largestSumAfterKNegations(intArrayOf(2, -3, -1, 5, -4), 2))
    }

    @Test
    fun oddKFlipsTheMinimumElement() {
        assertEquals(4, solution.largestSumAfterKNegations(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun handlesAllNegativeInput() {
        assertEquals(6, solution.largestSumAfterKNegations(intArrayOf(-5, -2, -3), 2))
    }
}
