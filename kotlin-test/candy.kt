package candy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CandyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.candy(intArrayOf(1, 0, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.candy(intArrayOf(1, 2, 2)))
    }

    @Test
    fun testSingleChild() {
        assertEquals(1, solution.candy(intArrayOf(1)))
    }

    @Test
    fun testStrictlyIncreasing() {
        assertEquals(6, solution.candy(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testStrictlyDecreasing() {
        assertEquals(6, solution.candy(intArrayOf(3, 2, 1)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(3, solution.candy(intArrayOf(1, 1, 1)))
    }
}
