package validsudoku

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidSudokuTest {
    private fun board(vararg rows: String): Array<CharArray> =
        rows.map { it.toCharArray() }.toTypedArray()

    private fun validBoard(): Array<CharArray> = board(
        "53..7....",
        "6..195...",
        ".98....6.",
        "8...6...3",
        "4..8.3..1",
        "7...2...6",
        ".6....28.",
        "...419..5",
        "....8..79"
    )

    @Test
    fun leetCodeValidExample() {
        assertTrue(Solution().isValidSudoku(validBoard()))
    }

    @Test
    fun duplicateInRow() {
        val b = validBoard()
        b[8][2] = '9'
        assertFalse(Solution().isValidSudoku(b))
    }

    @Test
    fun duplicateInColumn() {
        val b = validBoard()
        b[3][0] = '5'
        assertFalse(Solution().isValidSudoku(b))
    }

    @Test
    fun duplicateInRegion() {
        val b = validBoard()
        b[0][0] = '9'
        assertFalse(Solution().isValidSudoku(b))
    }

    @Test
    fun emptyBoard() {
        assertTrue(Solution().isValidSudoku(board(
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            "........."
        )))
    }
}
