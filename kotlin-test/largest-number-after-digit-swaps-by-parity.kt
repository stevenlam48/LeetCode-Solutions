package largestnumberafterdigitswapsbyparity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestNumberAfterDigitSwapsByParityTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3412, solution.largestInteger(1234))
    }

    @Test
    fun testExample2() {
        assertEquals(87655, solution.largestInteger(65875))
    }

    @Test
    fun testSingleDigit() {
        assertEquals(7, solution.largestInteger(7))
    }

    @Test
    fun testZero() {
        assertEquals(0, solution.largestInteger(0))
    }

    @Test
    fun testAllSameParity() {
        assertEquals(8642, solution.largestInteger(2468))
        assertEquals(97531, solution.largestInteger(13579))
    }
}
