package maxdifferenceyoucangetfromchanginganinteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxDifferenceYouCanGetFromChangingAnIntegerTest {
    private val solution = Solution()

    @Test
    fun computesFirstExample() {
        assertEquals(888, solution.maxDiff(555))
    }

    @Test
    fun computesSecondExample() {
        assertEquals(8, solution.maxDiff(9))
    }

    @Test
    fun replacesLeadingNonOneForMinimum() {
        assertEquals(800, solution.maxDiff(234))
    }

    @Test
    fun replacesNonLeadingDigitsWithZeroForMinimum() {
        assertEquals(820, solution.maxDiff(123))
    }

    @Test
    fun handlesZero() {
        assertEquals(0, solution.maxDiff(0))
    }

    @Test
    fun handlesLeadingOneAndZeros() {
        assertEquals(8000, solution.maxDiff(1000))
    }
}
