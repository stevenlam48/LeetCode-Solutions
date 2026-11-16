package checkadjacentdigitdifferences

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckAdjacentDigitDifferencesTest {
    private val solution = Solution()

    @Test
    fun consecutiveDigits() {
        assertTrue(solution.isAdjacentDiffAtMostTwo("012"))
    }

    @Test
    fun exactDifferenceOfTwo() {
        assertTrue(solution.isAdjacentDiffAtMostTwo("13579"))
    }

    @Test
    fun differenceExceedsTwo() {
        assertFalse(solution.isAdjacentDiffAtMostTwo("085"))
    }

    @Test
    fun emptyAndSingleDigit() {
        assertTrue(solution.isAdjacentDiffAtMostTwo(""))
        assertTrue(solution.isAdjacentDiffAtMostTwo("9"))
    }
}
