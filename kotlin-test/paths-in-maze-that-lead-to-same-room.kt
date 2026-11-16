package pathsinmazethatleadtosameroom

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PathsInMazeThatLeadToSameRoomTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val corridors = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(5, 2),
            intArrayOf(4, 1),
            intArrayOf(2, 4),
            intArrayOf(3, 1),
            intArrayOf(3, 4)
        )
        assertEquals(2, solution.numberOfPaths(5, corridors))
    }

    @Test
    fun testNoCycles() {
        val corridors = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(0, solution.numberOfPaths(4, corridors))
    }

    @Test
    fun testSingleTriangle() {
        val corridors = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertEquals(1, solution.numberOfPaths(3, corridors))
    }
}
