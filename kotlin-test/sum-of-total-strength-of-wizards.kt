package sumoftotalstrengthofwizards

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfTotalStrengthOfWizardsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(44, solution.totalStrength(intArrayOf(1, 3, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(213, solution.totalStrength(intArrayOf(5, 4, 6)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.totalStrength(intArrayOf(1)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(8, solution.totalStrength(intArrayOf(1, 2)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(10, solution.totalStrength(intArrayOf(1, 1, 1)))
    }
}
