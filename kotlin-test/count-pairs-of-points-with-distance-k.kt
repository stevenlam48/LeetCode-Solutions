package countpairsofpointswithdistancek

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPairsOfPointsWithDistanceKTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val coordinates = arrayOf(
            intArrayOf(1, 2), intArrayOf(4, 2), intArrayOf(1, 3), intArrayOf(5, 2)
        )
        assertEquals(2, solution.countPairs(coordinates, 5))
    }

    @Test
    fun testExample2() {
        val coordinates = arrayOf(
            intArrayOf(1, 3), intArrayOf(1, 3), intArrayOf(1, 3)
        )
        assertEquals(3, solution.countPairs(coordinates, 0))
    }

    @Test
    fun testSinglePoint() {
        val coordinates = arrayOf(intArrayOf(0, 0))
        assertEquals(0, solution.countPairs(coordinates, 1))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countPairs(arrayOf(), 3))
    }

    @Test
    fun testTwoPoints() {
        val coordinates = arrayOf(intArrayOf(0, 0), intArrayOf(1, 1))
        assertEquals(1, solution.countPairs(coordinates, 2))
    }
}
