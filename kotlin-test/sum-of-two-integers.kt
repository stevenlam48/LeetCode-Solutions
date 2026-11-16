package sumoftwointegers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfTwoIntegersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.getSum(1, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(5, solution.getSum(2, 3))
    }

    @Test
    fun testOppositeSigns() {
        assertEquals(0, solution.getSum(-1, 1))
    }

    @Test
    fun testBothNegative() {
        assertEquals(-5, solution.getSum(-2, -3))
    }

    @Test
    fun testZeros() {
        assertEquals(0, solution.getSum(0, 0))
    }
}
