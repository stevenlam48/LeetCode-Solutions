package numberofwaystoarriveatdestination

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToArriveAtDestinationTest {
    @Test
    fun twoDisjointPaths() {
        val roads = arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 2, 1), intArrayOf(1, 3, 1), intArrayOf(2, 3, 1))
        assertEquals(2, Solution().countPaths(4, roads))
    }

    @Test
    fun singleRoad() {
        assertEquals(1, Solution().countPaths(2, arrayOf(intArrayOf(1, 0, 10))))
    }

    @Test
    fun twoShortestPaths() {
        val roads = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1), intArrayOf(0, 2, 2))
        assertEquals(2, Solution().countPaths(3, roads))
    }

    @Test
    fun equalLengthPaths() {
        val roads = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 2), intArrayOf(0, 2, 4))
        assertEquals(2, Solution().countPaths(3, roads))
    }

    @Test
    fun uniqueShortestPath() {
        val roads = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 2, 1), intArrayOf(2, 3, 1), intArrayOf(0, 3, 4))
        assertEquals(1, Solution().countPaths(4, roads))
    }
}
