package twistedmirrorpathcount

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TwistedMirrorPathCountTest {
    @Test
    fun openRectangularGrids() {
        assertEquals(2, Solution().uniquePaths(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
        assertEquals(3, Solution().uniquePaths(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))))
        assertEquals(3, Solution().uniquePaths(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun mirrorsChangeAvailableDirections() {
        assertEquals(2, Solution().uniquePaths(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
        assertEquals(1, Solution().uniquePaths(arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))))
        assertEquals(1, Solution().uniquePaths(arrayOf(intArrayOf(0, 1), intArrayOf(0, 1))))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().uniquePaths(arrayOf(intArrayOf(0))))
        assertEquals(1, Solution().uniquePaths(arrayOf(intArrayOf(1))))
    }
}
