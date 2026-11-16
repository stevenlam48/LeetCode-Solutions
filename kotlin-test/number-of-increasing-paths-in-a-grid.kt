package numberofincreasingpathsinagrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfIncreasingPathsInAGridTest {
    @Test
    fun testExample1() {
        assertEquals(8, Solution().countPaths(arrayOf(intArrayOf(1, 1), intArrayOf(3, 4))))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().countPaths(arrayOf(intArrayOf(1), intArrayOf(2))))
    }

    @Test
    fun testSingleCell() {
        assertEquals(1, Solution().countPaths(arrayOf(intArrayOf(1))))
    }

    @Test
    fun testStrictlyIncreasingGrid() {
        assertEquals(10, Solution().countPaths(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }
}
