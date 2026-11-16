package findthecountofnumberswhicharenotspecial

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheCountOfNumbersWhichAreNotSpecialTest {
    @Test
    fun excludesOnlyPrimeSquare() {
        assertEquals(3, Solution().nonSpecialCount(5, 7))
    }

    @Test
    fun excludesRangeContainingOnlySpecialNumber() {
        assertEquals(0, Solution().nonSpecialCount(4, 4))
    }

    @Test
    fun countsFromOne() {
        assertEquals(14, Solution().nonSpecialCount(1, 16))
    }

    @Test
    fun handlesSpecialNumbersAtBothBoundaries() {
        assertEquals(23, Solution().nonSpecialCount(25, 49))
    }
}
