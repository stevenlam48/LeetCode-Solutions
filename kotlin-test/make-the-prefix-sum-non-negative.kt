package maketheprefixsumnonnegative

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeThePrefixSumNonNegativeTest {
    @Test
    fun testSingleNegativeMove() {
        assertEquals(1, Solution().makePrefSumNonNegative(intArrayOf(1, -2, 3)))
    }

    @Test
    fun testAllNegative() {
        assertEquals(3, Solution().makePrefSumNonNegative(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun testAllNonNegative() {
        assertEquals(0, Solution().makePrefSumNonNegative(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testMoveLargeNegative() {
        assertEquals(1, Solution().makePrefSumNonNegative(intArrayOf(-5, 4, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().makePrefSumNonNegative(intArrayOf(-7)))
    }
}
