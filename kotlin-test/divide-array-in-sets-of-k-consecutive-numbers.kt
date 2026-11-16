package dividearrayinsetsofkconsecutivenumbers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DivideArrayInSetsOfKConsecutiveNumbersTest {
    private val solution = Solution()

    @Test
    fun overlappingConsecutiveGroups() {
        assertTrue(solution.isPossibleDivide(intArrayOf(1, 2, 3, 3, 4, 4, 5, 6), 4))
    }

    @Test
    fun lengthNotDivisibleByGroupSize() {
        assertFalse(solution.isPossibleDivide(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun pairs() {
        assertTrue(solution.isPossibleDivide(intArrayOf(1, 2, 3, 4, 5, 6), 2))
    }

    @Test
    fun missingConsecutiveValue() {
        assertFalse(solution.isPossibleDivide(intArrayOf(1, 2, 2, 4), 2))
    }
}
