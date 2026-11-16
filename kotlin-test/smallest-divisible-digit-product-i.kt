package smallestdivisibledigitproducti

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestDivisibleDigitProductITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.smallestNumber(10, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(16, solution.smallestNumber(15, 3))
    }

    @Test
    fun testTIsOne() {
        assertEquals(1, solution.smallestNumber(1, 1))
    }

    @Test
    fun testNeedsNextNumber() {
        assertEquals(10, solution.smallestNumber(9, 2))
    }

    @Test
    fun testAlreadyDivisible() {
        assertEquals(7, solution.smallestNumber(7, 7))
    }

    @Test
    fun testZeroDigitMakesProductZero() {
        assertEquals(10, solution.smallestNumber(8, 7))
    }
}
