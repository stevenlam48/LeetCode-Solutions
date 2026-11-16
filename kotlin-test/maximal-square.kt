package maximalsquare

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximalSquareTest {
    private val solution = Solution()

    private fun matrixOf(vararg rows: String): Array<CharArray> =
        Array(rows.size) { rows[it].toCharArray() }

    @Test
    fun testExample1() {
        val matrix = matrixOf("10100", "10111", "11111", "10010")
        assertEquals(4, solution.maximalSquare(matrix))
    }

    @Test
    fun testDiagonalOnes() {
        assertEquals(1, solution.maximalSquare(matrixOf("01", "10")))
    }

    @Test
    fun testSingleZero() {
        assertEquals(0, solution.maximalSquare(matrixOf("0")))
    }

    @Test
    fun testAllOnes() {
        assertEquals(4, solution.maximalSquare(matrixOf("11", "11")))
    }
}
