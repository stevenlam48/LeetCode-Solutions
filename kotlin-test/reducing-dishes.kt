package reducingdishes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReducingDishesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(14, solution.maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9)))
    }

    @Test
    fun testExample2() {
        assertEquals(20, solution.maxSatisfaction(intArrayOf(4, 3, 2)))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.maxSatisfaction(intArrayOf(-1, -4, -5)))
    }

    @Test
    fun testSinglePositive() {
        assertEquals(5, solution.maxSatisfaction(intArrayOf(5)))
    }

    @Test
    fun testSingleNegative() {
        assertEquals(0, solution.maxSatisfaction(intArrayOf(-5)))
    }

    @Test
    fun testZerosAndPositives() {
        assertEquals(26, solution.maxSatisfaction(intArrayOf(0, 0, 1, 2, 3)))
    }
}
