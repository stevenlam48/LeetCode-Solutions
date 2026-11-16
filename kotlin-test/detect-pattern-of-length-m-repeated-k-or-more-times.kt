package detectpatternoflengthmrepeatedkormoretimes

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetectPatternOfLengthMRepeatedKOrMoreTimesTest {
    private val solution = Solution()

    @Test
    fun repeatedTwoElementPatternIsFound() {
        assertTrue(solution.containsPattern(intArrayOf(1, 2, 4, 4, 4, 4), 1, 3))
    }

    @Test
    fun patternRepeatsAtStart() {
        assertTrue(solution.containsPattern(intArrayOf(1, 2, 1, 2, 1, 1, 1, 3), 2, 2))
    }

    @Test
    fun patternDoesNotRepeatEnough() {
        assertFalse(solution.containsPattern(intArrayOf(1, 2, 1, 2, 1, 3), 2, 3))
    }

    @Test
    fun inputTooShortHasNoPattern() {
        assertFalse(solution.containsPattern(intArrayOf(1, 2, 3), 2, 2))
    }

    @Test
    fun nonAdjacentRunsDoNotCombine() {
        assertFalse(solution.containsPattern(intArrayOf(2, 2, 1, 2, 2, 1), 1, 3))
    }
}
