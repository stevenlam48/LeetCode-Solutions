package countthedigitsthatdivideanumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheDigitsThatDivideANumberTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.countDigits(7))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.countDigits(121))
    }

    @Test
    fun testExample3() {
        assertEquals(4, solution.countDigits(1248))
    }

    @Test
    fun testSingleDigitOne() {
        assertEquals(1, solution.countDigits(1))
    }

    @Test
    fun testRepeatedDigit() {
        assertEquals(3, solution.countDigits(111))
    }
}
