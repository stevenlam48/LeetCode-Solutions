package pathwithminimumeffort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PathWithMinimumEffortTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val heights = arrayOf(
            intArrayOf(1, 2, 2),
            intArrayOf(3, 8, 2),
            intArrayOf(5, 3, 5)
        )
        assertEquals(2, solution.minimumEffortPath(heights))
    }

    @Test
    fun testExample2() {
        val heights = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(3, 8, 4),
            intArrayOf(5, 3, 5)
        )
        assertEquals(1, solution.minimumEffortPath(heights))
    }

    @Test
    fun testExample3() {
        val heights = arrayOf(
            intArrayOf(1, 2, 1, 1, 1),
            intArrayOf(1, 2, 1, 2, 1),
            intArrayOf(1, 2, 1, 2, 1),
            intArrayOf(1, 2, 1, 2, 1),
            intArrayOf(1, 1, 1, 2, 1)
        )
        assertEquals(0, solution.minimumEffortPath(heights))
    }

    @Test
    fun testSingleCell() {
        val heights = arrayOf(intArrayOf(1))
        assertEquals(0, solution.minimumEffortPath(heights))
    }
}
