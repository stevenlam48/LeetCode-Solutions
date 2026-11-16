package countsquaresubmatriceswithallones

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSquareSubmatricesWithAllOnesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1)
        )
        assertEquals(15, solution.countSquares(matrix))
    }

    @Test
    fun example2() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
        )
        assertEquals(7, solution.countSquares(matrix))
    }

    @Test
    fun singleOne() {
        assertEquals(1, solution.countSquares(arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleZero() {
        assertEquals(0, solution.countSquares(arrayOf(intArrayOf(0))))
    }

    @Test
    fun allOnesTwoByTwo() {
        val matrix = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(5, solution.countSquares(matrix))
    }
}
