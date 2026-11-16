package smallestdivisibledigitproductii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestDivisibleDigitProductIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("1488", solution.smallestNumber("1234", 256))
    }

    @Test
    fun testExample2() {
        assertEquals("12355", solution.smallestNumber("12355", 50))
    }

    @Test
    fun testExample3() {
        assertEquals("114", solution.smallestNumber("111", 4))
    }

    @Test
    fun testZeroIsReplaced() {
        assertEquals("12", solution.smallestNumber("10", 2))
    }

    @Test
    fun testTIsOne() {
        assertEquals("1", solution.smallestNumber("1", 1))
    }

    @Test
    fun testImpossible() {
        assertEquals("-1", solution.smallestNumber("1", 11))
    }

    @Test
    fun testNeedsLongerNumber() {
        assertEquals("25", solution.smallestNumber("1", 10))
    }
}
