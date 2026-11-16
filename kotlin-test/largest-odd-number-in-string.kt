package largestoddnumberinstring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestOddNumberInStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("5", solution.largestOddNumber("52"))
    }

    @Test
    fun testExample2() {
        assertEquals("", solution.largestOddNumber("4206"))
    }

    @Test
    fun testExample3() {
        assertEquals("35427", solution.largestOddNumber("35427"))
    }

    @Test
    fun testSingleOddDigit() {
        assertEquals("1", solution.largestOddNumber("1"))
    }

    @Test
    fun testTrailingZero() {
        assertEquals("1", solution.largestOddNumber("10"))
    }
}
