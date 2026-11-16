package thirdmaximumnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThirdMaximumNumberTest {
    private val solution = Solution()

    @Test
    fun threeDistinctNumbers() {
        assertEquals(1, solution.thirdMax(intArrayOf(3, 2, 1)))
    }

    @Test
    fun fewerThanThreeDistinctNumbersReturnsMaximum() {
        assertEquals(2, solution.thirdMax(intArrayOf(1, 2)))
    }

    @Test
    fun duplicatesAreIgnored() {
        assertEquals(1, solution.thirdMax(intArrayOf(2, 2, 3, 1)))
    }

    @Test
    fun handlesNegativeAndExtremeValues() {
        assertEquals(Int.MIN_VALUE, solution.thirdMax(intArrayOf(Int.MIN_VALUE, -1, 0)))
    }

    @Test
    fun repeatedMaximumDoesNotChangeResult() {
        assertEquals(1, solution.thirdMax(intArrayOf(5, 5, 4, 4, 1)))
    }
}
