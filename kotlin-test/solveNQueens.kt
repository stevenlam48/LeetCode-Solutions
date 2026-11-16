package solveNQueens

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolveNQueensTest {
    @Test
    fun fourQueens() {
        val expected = setOf(
            listOf(".Q..", "...Q", "Q...", "..Q."),
            listOf("..Q.", "Q...", "...Q", ".Q..")
        )
        assertEquals(expected, Solution().solveNQueens(4).toSet())
        assertEquals(2, Solution().solveNQueens(4).size)
    }

    @Test
    fun oneQueen() {
        assertEquals(listOf(listOf("Q")), Solution().solveNQueens(1))
    }

    @Test
    fun twoQueens() {
        assertEquals(emptyList<List<String>>(), Solution().solveNQueens(2))
    }

    @Test
    fun threeQueens() {
        assertEquals(emptyList<List<String>>(), Solution().solveNQueens(3))
    }
}
