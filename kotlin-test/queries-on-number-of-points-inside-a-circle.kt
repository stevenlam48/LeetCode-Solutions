package queriesonnumberofpointsinsideacircle

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueriesOnNumberOfPointsInsideACircleTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val points = arrayOf(
            intArrayOf(1, 3), intArrayOf(3, 3), intArrayOf(5, 3), intArrayOf(2, 2)
        )
        val queries = arrayOf(
            intArrayOf(2, 3, 1), intArrayOf(4, 3, 1), intArrayOf(1, 1, 2)
        )
        assertArrayEquals(intArrayOf(3, 2, 2), solution.countPoints(points, queries))
    }

    @Test
    fun testExample2() {
        val points = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(5, 5))
        val queries = arrayOf(intArrayOf(1, 2, 2), intArrayOf(2, 2, 2), intArrayOf(4, 3, 2), intArrayOf(4, 3, 3))
        assertArrayEquals(intArrayOf(2, 3, 2, 4), solution.countPoints(points, queries))
    }

    @Test
    fun testNoPoints() {
        assertArrayEquals(intArrayOf(0), solution.countPoints(arrayOf(), arrayOf(intArrayOf(0, 0, 5))))
    }

    @Test
    fun testBoundaryIncluded() {
        val points = arrayOf(intArrayOf(0, 0), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(2), solution.countPoints(points, arrayOf(intArrayOf(0, 0, 5))))
    }
}
