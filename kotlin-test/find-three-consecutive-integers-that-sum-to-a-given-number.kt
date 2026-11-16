package findthreeconsecutiveintegersthatsumtoagivennumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindThreeConsecutiveIntegersThatSumToAGivenNumberTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(listOf(10L, 11L, 12L), solution.sumOfThree(33))
    }

    @Test
    fun testExample2() {
        assertEquals(listOf<Long>(), solution.sumOfThree(4))
    }

    @Test
    fun testZero() {
        assertEquals(listOf(-1L, 0L, 1L), solution.sumOfThree(0))
    }

    @Test
    fun testNegativeMultipleOfThree() {
        assertEquals(listOf(-2L, -1L, 0L), solution.sumOfThree(-3))
    }

    @Test
    fun testLargeNumber() {
        assertEquals(
            listOf(333333333333333L, 333333333333334L, 333333333333335L),
            solution.sumOfThree(1000000000000002L)
        )
    }
}
