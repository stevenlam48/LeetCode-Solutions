package findnumberswithevennumberofdigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNumbersWithEvenNumberOfDigitsTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(2, solution.findNumbers(intArrayOf(12, 345, 2, 6, 7896)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(1, solution.findNumbers(intArrayOf(555, 901, 482, 1771)))
    }

    @Test
    fun includesZeroAndUpperBound() {
        assertEquals(2, solution.findNumbers(intArrayOf(0, 10, 100000)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, solution.findNumbers(intArrayOf()))
    }
}
