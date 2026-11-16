package shortestpathinahiddengrid

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

private class FakeGridMaster(private val grid: List<String>) : GridMaster {
    private var r = 0
    private var c = 0

    private fun delta(direction: Char): Pair<Int, Int> = when (direction) {
        'L' -> 0 to -1
        'R' -> 0 to 1
        'U' -> -1 to 0
        else -> 1 to 0
    }

    override fun canMove(direction: Char): Boolean {
        val (dr, dc) = delta(direction)
        val nr = r + dr
        val nc = c + dc
        return nr in grid.indices && nc in grid[0].indices && grid[nr][nc] != '#'
    }

    override fun move(direction: Char) {
        val (dr, dc) = delta(direction)
        r += dr
        c += dc
    }

    override fun isTarget(): Boolean = grid[r][c] == 'T'
}

class ShortestPathInAHiddenGridTest {
    @Test
    fun findsShortestPathAroundAWall() {
        val grid = listOf(
            "...",
            ".#.",
            "..T"
        )
        assertEquals(4, Solution().findShortestPath(FakeGridMaster(grid)))
    }

    @Test
    fun walksALongDetour() {
        val grid = listOf(
            "..#..",
            "..#..",
            "..#..",
            "..#..",
            "...T."
        )
        assertEquals(7, Solution().findShortestPath(FakeGridMaster(grid)))
    }

    @Test
    fun targetAtStartHasZeroDistance() {
        assertEquals(0, Solution().findShortestPath(FakeGridMaster(listOf("T"))))
    }

    @Test
    fun returnsMinusOneWhenTargetIsUnreachable() {
        val grid = listOf(
            ".#.",
            "#.#",
            ".#."
        )
        assertEquals(-1, Solution().findShortestPath(FakeGridMaster(grid)))
    }
}
