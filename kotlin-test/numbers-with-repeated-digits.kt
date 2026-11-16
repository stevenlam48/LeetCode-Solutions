package numberswithrepeateddigits

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersWithRepeatedDigitsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.numDupDigitsAtMostN(20))
    }

    @Test
    fun testExample2() {
        assertEquals(10, solution.numDupDigitsAtMostN(100))
    }

    @Test
    fun testExample3() {
        assertEquals(262, solution.numDupDigitsAtMostN(1000))
    }

    @Test
    fun testSmall() {
        assertEquals(0, solution.numDupDigitsAtMostN(9))
        assertEquals(1, solution.numDupDigitsAtMostN(11))
    }
}
