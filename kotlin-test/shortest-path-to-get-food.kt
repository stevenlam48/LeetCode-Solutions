package shortestpathtogetfood

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestPathToGetFoodTest {
    @Test
    fun findsFoodBehindOpenSpace() {
        val grid = arrayOf(
            "XXXXXX".toCharArray(),
            "X*OOOX".toCharArray(),
            "XOO#OX".toCharArray(),
            "XXXXXX".toCharArray()
        )
        assertEquals(3, Solution().getFood(grid))
    }

    @Test
    fun returnsMinusOneWhenFoodIsUnreachable() {
        val grid = arrayOf(
            "XXXXX".toCharArray(),
            "X*XOX".toCharArray(),
            "XOX#X".toCharArray(),
            "XXXXX".toCharArray()
        )
        assertEquals(-1, Solution().getFood(grid))
    }

    @Test
    fun walksThroughALargerMaze() {
        val grid = arrayOf(
            "XXXXXXX".toCharArray(),
            "X*XOXXX".toCharArray(),
            "XOXOX#X".toCharArray(),
            "XOOOOOX".toCharArray(),
            "XXXXXXX".toCharArray()
        )
        assertEquals(7, Solution().getFood(grid))
    }

    @Test
    fun eatsAdjacentFood() {
        val grid = arrayOf(
            "X#X".toCharArray(),
            "X*X".toCharArray()
        )
        assertEquals(1, Solution().getFood(grid))
    }
}
