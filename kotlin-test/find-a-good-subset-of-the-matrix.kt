package findagoodsubsetofthematrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindAGoodSubsetOfTheMatrixTest {
    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 0)
        )
        assertEquals(emptyList<Int>(), Solution().goodSubsetofBinaryMatrix(grid))
    }

    @Test
    fun example2() {
        assertEquals(listOf(0), Solution().goodSubsetofBinaryMatrix(arrayOf(intArrayOf(0))))
    }

    @Test
    fun example3() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(emptyList<Int>(), Solution().goodSubsetofBinaryMatrix(grid))
    }

    @Test
    fun complementaryRows() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        assertEquals(listOf(0, 1), Solution().goodSubsetofBinaryMatrix(grid))
    }

    @Test
    fun zeroRowAtEnd() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(0, 0)
        )
        assertEquals(listOf(2), Solution().goodSubsetofBinaryMatrix(grid))
    }

    @Test
    fun returnedSubsetIsValid() {
        val grid = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 0)
        )
        val result = Solution().goodSubsetofBinaryMatrix(grid)
        assertTrue(result.size <= 2)
        for (j in grid[0].indices) {
            var sum = 0
            for (i in result) {
                sum += grid[i][j]
            }
            assertTrue(sum <= 1)
        }
    }
}
