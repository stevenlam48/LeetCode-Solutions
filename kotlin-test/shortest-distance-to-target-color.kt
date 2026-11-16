package shortestdistancetotargetcolor

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestDistanceToTargetColorTest {
    @Test
    fun answersQueriesAtAndBeforeTargetOccurrences() {
        val colors = intArrayOf(1, 1, 2, 1, 3, 2, 2, 3, 3)
        val queries = arrayOf(intArrayOf(2, 2), intArrayOf(6, 1), intArrayOf(4, 3), intArrayOf(7, 2))
        assertArrayEquals(intArrayOf(0, 3, 0, 1), Solution().shortestDistanceColor(colors, queries))
    }

    @Test
    fun returnsMinusOneForAbsentColor() {
        val colors = intArrayOf(1, 2, 1)
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 3), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(-1, -1, -1), Solution().shortestDistanceColor(colors, queries))
    }

    @Test
    fun handlesSinglePositionAndTies() {
        assertArrayEquals(
            intArrayOf(0, -1, -1),
            Solution().shortestDistanceColor(intArrayOf(2), arrayOf(intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(0, 3)))
        )
        assertArrayEquals(
            intArrayOf(1),
            Solution().shortestDistanceColor(intArrayOf(2, 1, 2), arrayOf(intArrayOf(1, 2)))
        )
    }
}
