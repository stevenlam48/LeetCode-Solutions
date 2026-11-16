package rottingoranges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RottingOrangesTest {
    @Test
    fun leetCodeExampleTakesFourMinutes() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1)
        )
        assertEquals(4, Solution().orangesRotting(grid))
    }

    @Test
    fun leetCodeExampleImpossible() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1)
        )
        assertEquals(-1, Solution().orangesRotting(grid))
    }

    @Test
    fun leetCodeExampleAlreadyAllRotten() {
        val grid = arrayOf(intArrayOf(0, 2))
        assertEquals(0, Solution().orangesRotting(grid))
    }

    @Test
    fun emptyCellsOnly() {
        val grid = arrayOf(intArrayOf(0))
        assertEquals(0, Solution().orangesRotting(grid))
    }

    @Test
    fun freshOrangeWithoutRotten() {
        val grid = arrayOf(intArrayOf(1))
        assertEquals(-1, Solution().orangesRotting(grid))
    }

    @Test
    fun singleRowSpreadsRight() {
        val grid = arrayOf(intArrayOf(2, 1, 1, 1))
        assertEquals(3, Solution().orangesRotting(grid))
    }
}
