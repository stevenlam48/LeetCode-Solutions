package minimumTotal

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumTotalTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val triangle = arrayOf(
            intArrayOf(2),
            intArrayOf(3, 4),
            intArrayOf(6, 5, 7),
            intArrayOf(4, 1, 8, 3)
        )
        assertEquals(11, solution.minimumTotal(triangle))
    }

    @Test
    fun testSingleElement() {
        assertEquals(-10, solution.minimumTotal(arrayOf(intArrayOf(-10))))
    }

    @Test
    fun testNegativeValues() {
        val triangle = arrayOf(
            intArrayOf(-1),
            intArrayOf(2, 3),
            intArrayOf(1, -1, -3)
        )
        assertEquals(-1, solution.minimumTotal(triangle))
    }

    @Test
    fun testTwoRows() {
        val triangle = arrayOf(intArrayOf(1), intArrayOf(2, 3))
        assertEquals(3, solution.minimumTotal(triangle))
    }
}
