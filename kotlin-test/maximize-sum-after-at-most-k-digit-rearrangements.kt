package maximizesumafteratmostkdigitrearrangements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSumAfterAtMostKDigitRearrangementsTest {
    private val solution = Solution()

    @Test
    fun selectsTheLargestSingleGain() {
        assertEquals(31L, solution.maximizeSum(intArrayOf(10, 12), 1))
    }

    @Test
    fun selectsTheTwoLargestGains() {
        assertEquals(210L, solution.maximizeSum(intArrayOf(19, 28, 37), 2))
    }

    @Test
    fun rearrangesZeroDigitsIntoLeadingPositions() {
        assertEquals(1260L, solution.maximizeSum(intArrayOf(105, 507), 2))
    }

    @Test
    fun handlesUnchangedAndRepeatedDigits() {
        assertEquals(432L, solution.maximizeSum(intArrayOf(222, 120), 1))
    }

    @Test
    fun handlesSingleDigitInput() {
        assertEquals(7L, solution.maximizeSum(intArrayOf(7), 1))
    }
}
