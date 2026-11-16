package maximizeareaofsquareholeingrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeAreaOfSquareHoleInGridTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.maximizeSquareHoleArea(2, 1, intArrayOf(2, 3), intArrayOf(2)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.maximizeSquareHoleArea(1, 1, intArrayOf(2), intArrayOf(2)))
    }

    @Test
    fun testExample3() {
        assertEquals(4, solution.maximizeSquareHoleArea(2, 3, intArrayOf(2, 3), intArrayOf(2, 4)))
    }

    @Test
    fun testLongRuns() {
        assertEquals(
            16,
            solution.maximizeSquareHoleArea(3, 3, intArrayOf(2, 3, 4), intArrayOf(2, 3, 4))
        )
    }
}
