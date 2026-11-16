package librarylatefeecalculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LibraryLateFeeCalculatorTest {
    @Test
    fun computesLeetCodeExample() {
        assertEquals(32, Solution().lateFee(intArrayOf(5, 1, 7)))
    }

    @Test
    fun appliesEachFeeBandAtItsBoundaries() {
        assertEquals(54, Solution().lateFee(intArrayOf(1, 2, 5, 6, 7)))
    }

    @Test
    fun handlesEmptyAndZeroDayInputs() {
        assertEquals(0, Solution().lateFee(intArrayOf()))
        assertEquals(0, Solution().lateFee(intArrayOf(0, 0)))
    }

    @Test
    fun accumulatesSingleLateDayFeesSeparately() {
        assertEquals(3, Solution().lateFee(intArrayOf(1, 1, 1)))
    }
}
