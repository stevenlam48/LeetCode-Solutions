package minimumnumberofflipstomakebinarygridpalindromici

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToMakeBinaryGridPalindromicITest {
    private val solution = Solution()

    @Test
    fun diagonalMatrix() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(2, solution.minFlips(grid))
    }

    @Test
    fun columnsNeedFewerFlips() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 1),
            intArrayOf(0, 0)
        )
        assertEquals(1, solution.minFlips(grid))
    }

    @Test
    fun alreadyPalindromic() {
        val grid = arrayOf(intArrayOf(1), intArrayOf(1))
        assertEquals(0, solution.minFlips(grid))
    }

    @Test
    fun singleRowCanUseColumns() {
        val grid = arrayOf(intArrayOf(1, 0, 0))
        assertEquals(0, solution.minFlips(grid))
    }
}
