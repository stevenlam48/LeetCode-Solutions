package maximalrectangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximalRectangleTest {
    private val solution = Solution()

    private fun matrixOf(vararg rows: String): Array<CharArray> =
        Array(rows.size) { rows[it].toCharArray() }

    @Test
    fun testExample1() {
        val matrix = matrixOf("10100", "10111", "11111", "10010")
        assertEquals(6, solution.maximalRectangle(matrix))
    }

    @Test
    fun testSingleZero() {
        assertEquals(0, solution.maximalRectangle(matrixOf("0")))
    }

    @Test
    fun testSingleOne() {
        assertEquals(1, solution.maximalRectangle(matrixOf("1")))
    }

    @Test
    fun testAllOnes() {
        assertEquals(4, solution.maximalRectangle(matrixOf("11", "11")))
    }
}
