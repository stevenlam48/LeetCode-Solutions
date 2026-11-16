package largestmultipleofthree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestMultipleOfThreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("981", solution.largestMultipleOfThree(intArrayOf(8, 1, 9)))
    }

    @Test
    fun testExample2() {
        assertEquals("8760", solution.largestMultipleOfThree(intArrayOf(8, 6, 7, 1, 0)))
    }

    @Test
    fun testSingleDigitNotDivisible() {
        assertEquals("", solution.largestMultipleOfThree(intArrayOf(1)))
    }

    @Test
    fun testAllZeros() {
        assertEquals("0", solution.largestMultipleOfThree(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testAllOnes() {
        assertEquals("111", solution.largestMultipleOfThree(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testDeleteTwoDigits() {
        assertEquals("8760", solution.largestMultipleOfThree(intArrayOf(8, 6, 7, 1, 0)))
        assertEquals("9", solution.largestMultipleOfThree(intArrayOf(1, 1, 9)))
    }
}
