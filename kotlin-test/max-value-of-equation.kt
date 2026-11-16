package maxvalueofequation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxValueOfEquationTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val points = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 0),
            intArrayOf(3, 10),
            intArrayOf(4, 5),
            intArrayOf(5, 6)
        )
        assertEquals(16, solution.findMaxValueOfEquation(points, 1))
    }

    @Test
    fun testExample2() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(3, 0), intArrayOf(9, 2))
        assertEquals(3, solution.findMaxValueOfEquation(points, 3))
    }

    @Test
    fun testTwoPoints() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2))
        assertEquals(4, solution.findMaxValueOfEquation(points, 1))
    }

    @Test
    fun testNegativeValues() {
        val points = arrayOf(intArrayOf(0, -5), intArrayOf(1, -3), intArrayOf(2, -10))
        assertEquals(-7, solution.findMaxValueOfEquation(points, 1))
    }
}
