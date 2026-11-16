package splittingastringintodescendingconsecutivevalues

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SplittingAStringIntoDescendingConsecutiveValuesTest {
    private val solution = Solution()

    @Test
    fun rejectsSingleAscendingRun() {
        assertFalse(solution.splitString("1234"))
    }

    @Test
    fun acceptsExampleWithLeadingZero() {
        assertTrue(solution.splitString("050043"))
    }

    @Test
    fun rejectsExampleWithNonConsecutiveValues() {
        assertFalse(solution.splitString("9080701"))
    }

    @Test
    fun acceptsThreeDigitStartingValue() {
        assertTrue(solution.splitString("10009998"))
    }

    @Test
    fun rejectsSingleDigitBecauseTwoPartsAreRequired() {
        assertFalse(solution.splitString("7"))
    }
}
