package minimumobstacleremovaltoreachcorner

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumObstacleRemovalToReachCornerTest {

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
        assertEquals(2, Solution().minimumObstacles(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 0)
        )
        assertEquals(0, Solution().minimumObstacles(grid))
    }

    @Test
    fun testAllObstacles() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals(5, Solution().minimumObstacles(grid))
    }

    @Test
    fun testSingleCell() {
        assertEquals(0, Solution().minimumObstacles(arrayOf(intArrayOf(0))))
    }

    @Test
    fun testSingleRow() {
        assertEquals(1, Solution().minimumObstacles(arrayOf(intArrayOf(0, 1, 0))))
    }

    @Test
    fun testSingleColumn() {
        assertEquals(
            2,
            Solution().minimumObstacles(
                arrayOf(
                    intArrayOf(0),
                    intArrayOf(1),
                    intArrayOf(1)
                )
            )
        )
    }
}
