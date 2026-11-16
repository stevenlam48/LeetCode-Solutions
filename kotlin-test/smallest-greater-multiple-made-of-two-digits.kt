package smallestgreatermultiplemadeoftwodigits

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestGreaterMultipleMadeOfTwoDigitsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.findInteger(2, 3, 4))
    }

    @Test
    fun testExample2() {
        assertEquals(24, solution.findInteger(3, 4, 2))
    }

    @Test
    fun testExample3() {
        assertEquals(12, solution.findInteger(2, 1, 2))
    }

    @Test
    fun testTwoDigitResult() {
        assertEquals(22, solution.findInteger(11, 1, 2))
    }

    @Test
    fun testSameDigits() {
        assertEquals(11, solution.findInteger(1, 1, 1))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, solution.findInteger(4, 3, 5))
    }
}
