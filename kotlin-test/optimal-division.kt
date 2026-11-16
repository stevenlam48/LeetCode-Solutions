package optimaldivision

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OptimalDivisionTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("1000/(100/10/2)", solution.optimalDivision(intArrayOf(1000, 100, 10, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals("2/(3/4)", solution.optimalDivision(intArrayOf(2, 3, 4)))
    }

    @Test
    fun testSingle() {
        assertEquals("2", solution.optimalDivision(intArrayOf(2)))
    }

    @Test
    fun testTwo() {
        assertEquals("2/3", solution.optimalDivision(intArrayOf(2, 3)))
    }
}
