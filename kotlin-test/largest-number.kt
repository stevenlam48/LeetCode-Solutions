package largestnumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestNumberTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("210", solution.largestNumber(intArrayOf(10, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals("9534330", solution.largestNumber(intArrayOf(3, 30, 34, 5, 9)))
    }

    @Test
    fun testAllZeros() {
        assertEquals("0", solution.largestNumber(intArrayOf(0, 0)))
    }

    @Test
    fun testSingleElement() {
        assertEquals("1", solution.largestNumber(intArrayOf(1)))
    }

    @Test
    fun testEqualLengthNumbers() {
        assertEquals("9998", solution.largestNumber(intArrayOf(9, 9, 9, 8)))
    }
}
