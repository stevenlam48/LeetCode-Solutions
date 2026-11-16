package numberswithsameconsecutivedifferences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersWithSameConsecutiveDifferencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(181, 292, 707, 818, 929),
            solution.numsSameConsecDiff(3, 7).sortedArray()
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98),
            solution.numsSameConsecDiff(2, 1).sortedArray()
        )
    }

    @Test
    fun testSingleDigit() {
        assertArrayEquals(
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
            solution.numsSameConsecDiff(1, 0).sortedArray()
        )
    }

    @Test
    fun testZeroDifference() {
        assertArrayEquals(
            intArrayOf(11, 22, 33, 44, 55, 66, 77, 88, 99),
            solution.numsSameConsecDiff(2, 0).sortedArray()
        )
    }
}
