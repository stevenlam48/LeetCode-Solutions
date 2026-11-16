package applyoperationstomakeallarrayelementsequaltozero

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class ApplyOperationsToMakeAllArrayElementsEqualToZeroTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertTrue(solution.checkArray(intArrayOf(2, 2, 3, 1, 1, 0), 3))
    }

    @Test
    fun alreadyZero() {
        assertTrue(solution.checkArray(intArrayOf(0, 0, 0), 2))
    }

    @Test
    fun wholeArrayCanBeOneWindow() {
        assertTrue(solution.checkArray(intArrayOf(1, 1, 1), 3))
    }

    @Test
    fun trailingValueCannotBeRemoved() {
        assertFalse(solution.checkArray(intArrayOf(1, 2, 1), 3))
    }

    @Test
    fun windowOfSizeOneMatchesTheSourceAlgorithm() {
        assertTrue(solution.checkArray(intArrayOf(1, 1, 1), 1))
    }
}
