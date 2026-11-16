package minimizelengthofarrayusingoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeLengthOfArrayUsingOperationsTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(1, solution.minimumArrayLength(intArrayOf(1, 4, 3, 1)))
    }

    @Test
    fun repeatedDivisibleValues() {
        assertEquals(2, solution.minimumArrayLength(intArrayOf(5, 5, 5, 10, 5)))
    }

    @Test
    fun valueNotDivisibleByMinimum() {
        assertEquals(1, solution.minimumArrayLength(intArrayOf(2, 3, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.minimumArrayLength(intArrayOf(7)))
    }

    @Test
    fun evenNumberOfMinimumValues() {
        assertEquals(1, solution.minimumArrayLength(intArrayOf(6, 12, 18, 6)))
    }
}
