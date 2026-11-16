package shortestpathwithalternatingcolors

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathWithAlternatingColorsTest {
    @Test
    fun cannotUseTwoConsecutiveRedEdges() {
        val red = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertArrayEquals(
            intArrayOf(0, 1, -1),
            Solution().shortestAlternatingPaths(3, red, emptyArray())
        )
    }

    @Test
    fun blueEdgePointsTheWrongWay() {
        val red = arrayOf(intArrayOf(0, 1))
        val blue = arrayOf(intArrayOf(2, 1))
        assertArrayEquals(
            intArrayOf(0, 1, -1),
            Solution().shortestAlternatingPaths(3, red, blue)
        )
    }

    @Test
    fun returnsMinusOneForUnreachableNodes() {
        val red = arrayOf(intArrayOf(1, 0))
        val blue = arrayOf(intArrayOf(2, 1))
        assertArrayEquals(
            intArrayOf(0, -1, -1),
            Solution().shortestAlternatingPaths(3, red, blue)
        )
    }

    @Test
    fun reachesBothDirectNeighbors() {
        val red = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        val blue = arrayOf(intArrayOf(1, 0))
        assertArrayEquals(
            intArrayOf(0, 1, 1),
            Solution().shortestAlternatingPaths(3, red, blue)
        )
    }

    @Test
    fun handlesSingleNode() {
        assertArrayEquals(
            intArrayOf(0),
            Solution().shortestAlternatingPaths(1, emptyArray(), emptyArray())
        )
    }
}
