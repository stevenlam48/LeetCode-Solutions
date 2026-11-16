package minimumnumberofflipstomakebinarygridpalindromicii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToMakeBinaryGridPalindromicIITest {
    private val solution = Solution()

    @Test
    fun diagonalMatrix() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, solution.minFlips(grid))
    }

    @Test
    fun middleRowPair() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 1),
            intArrayOf(0, 0)
        )
        assertEquals(2, solution.minFlips(grid))
    }

    @Test
    fun centerOneMustFlip() {
        assertEquals(1, solution.minFlips(arrayOf(intArrayOf(1))))
    }

    @Test
    fun allOnesAlreadyValid() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(0, solution.minFlips(grid))
    }

    @Test
    fun differingMiddleColumnPair() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(1, solution.minFlips(grid))
    }
}
