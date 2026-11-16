package formsmallestnumberfromtwodigitarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FormSmallestNumberFromTwoDigitArraysTest {
    private val solution = Solution()

    @Test
    fun `no common digit combines minimum digits`() {
        assertEquals(15, solution.minNumber(intArrayOf(4, 1, 3), intArrayOf(5, 7)))
    }

    @Test
    fun `common digit is returned directly`() {
        assertEquals(3, solution.minNumber(intArrayOf(3, 5, 2, 6), intArrayOf(3, 1, 7)))
    }

    @Test
    fun `smallest of several common digits wins`() {
        assertEquals(2, solution.minNumber(intArrayOf(4, 8, 2), intArrayOf(9, 8, 7, 2)))
    }

    @Test
    fun `minimum digits are ordered across arrays`() {
        assertEquals(15, solution.minNumber(intArrayOf(7, 5, 6), intArrayOf(1, 4)))
    }
}
