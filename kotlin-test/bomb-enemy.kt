package bombenemy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BombEnemyTest {
    @Test
    fun example1() {
        val grid = arrayOf(
            charArrayOf('0', 'E', '0', '0'),
            charArrayOf('E', '0', 'W', 'E'),
            charArrayOf('0', 'E', '0', '0')
        )
        assertEquals(3, Solution().maxKilledEnemies(grid))
    }

    @Test
    fun allWalls() {
        val grid = arrayOf(
            charArrayOf('W', 'W', 'W'),
            charArrayOf('W', '0', 'W'),
            charArrayOf('W', 'W', 'W')
        )
        assertEquals(0, Solution().maxKilledEnemies(grid))
    }

    @Test
    fun singleRow() {
        val grid = arrayOf(charArrayOf('0', 'E'))
        assertEquals(1, Solution().maxKilledEnemies(grid))
    }

    @Test
    fun emptyGrid() {
        assertEquals(0, Solution().maxKilledEnemies(emptyArray()))
    }

    @Test
    fun noEmptyCell() {
        val grid = arrayOf(charArrayOf('E', 'E'))
        assertEquals(0, Solution().maxKilledEnemies(grid))
    }
}
