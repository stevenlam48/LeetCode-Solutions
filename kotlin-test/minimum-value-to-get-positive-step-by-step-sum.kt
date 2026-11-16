package minimumvaluetogetpositivestepbystepsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumValueToGetPositiveStepByStepSumTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.minStartValue(intArrayOf(-3, 2, -3, 4, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.minStartValue(intArrayOf(1, 2)))
    }

    @Test
    fun testExample3() {
        assertEquals(5, solution.minStartValue(intArrayOf(1, -2, -3)))
    }

    @Test
    fun testAllPositive() {
        assertEquals(1, solution.minStartValue(intArrayOf(2, 3, 4)))
    }

    @Test
    fun testSingleNegative() {
        assertEquals(4, solution.minStartValue(intArrayOf(-3)))
    }
}
